package betterwithaddons.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockLantern extends BlockBase {
    public static PropertyBool LIT = PropertyBool.create("lit");
    public static PropertyDirection FACING = PropertyDirection.create("facing");

    public BlockLantern(String name, Material materialIn) {
        super(name, materialIn);
        setDefaultState(getDefaultState().withProperty(FACING,EnumFacing.UP).withProperty(LIT,false));
    }

    @Override
    public int getLightValue(IBlockState state) {
        return state.getValue(LIT) ? 10 : 0;
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        boolean canStay = false;

        for(EnumFacing facing : EnumFacing.VALUES)
        {
            if(canBlockStay(worldIn,pos,facing))
                canStay = true;
        }

        return super.canPlaceBlockAt(worldIn, pos) && canStay;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        checkAndDrop(worldIn,state,pos);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos frompos) {
        super.neighborChanged(state, worldIn, pos, blockIn,frompos);
        checkAndDrop(worldIn,state,pos);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        boolean isLit = state.getValue(LIT);

        ItemStack heldItem = playerIn.getHeldItem(hand);

        if(!isLit && heldItem != null && heldItem.getItem() == Items.FLINT_AND_STEEL)
        {
            worldIn.setBlockState(pos,state.withProperty(LIT,true));
            heldItem.damageItem(1,playerIn);
            return true;
        }
        else if(isLit && heldItem == null)
        {
            worldIn.setBlockState(pos,state.withProperty(LIT,false));
            return true;
        }

        return false;
    }

    public void checkAndDrop(World worldIn, IBlockState state, BlockPos pos)
    {
        if (!worldIn.isRemote && !canBlockStay(worldIn, pos, state.getValue(FACING)))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    public boolean canBlockStay(World worldIn, BlockPos pos, EnumFacing attachDir)
    {
        IBlockState attach = worldIn.getBlockState(pos.offset(attachDir));
        return attach.isSideSolid(worldIn,pos, attachDir.getOpposite());
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        EnumFacing attachDir = facing.getOpposite();
        if (canBlockStay(worldIn, pos, attachDir))
        {
            return this.getDefaultState().withProperty(FACING, attachDir);
        }
        else
        {
            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if (canBlockStay(worldIn, pos, enumfacing))
                {
                    return this.getDefaultState().withProperty(FACING, enumfacing);
                }
            }

            return this.getDefaultState();
        }
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7)).withProperty(LIT,(meta & 8) == 8);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex() | (state.getValue(LIT) ? 8 : 0);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LIT, FACING);
    }
}
