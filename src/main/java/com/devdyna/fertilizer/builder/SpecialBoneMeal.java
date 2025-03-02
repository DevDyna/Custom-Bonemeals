package com.devdyna.fertilizer.builder;

import com.devdyna.fertilizer.core.Utils.LevelUtil;
import com.devdyna.fertilizer.core.Utils.MathUtil;
import com.devdyna.fertilizer.core.Utils.TipBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpecialBoneMeal extends TipBuilder {

    private static int sx = BoneMealItem.GRASS_SPREAD_WIDTH;
    private static int sy = BoneMealItem.GRASS_SPREAD_HEIGHT;
    private static int sz = BoneMealItem.GRASS_SPREAD_WIDTH;
    private static SoundEvent sd = SoundEvents.BONE_MEAL_USE;
    private static SimpleParticleType pt = ParticleTypes.HAPPY_VILLAGER;
    private static TagKey<Block> bl = BlockTags.SMALL_FLOWERS;
    private static TagKey<Block> bs = BlockTags.DIRT;
    private static TagKey<Block> br = BlockTags.AIR;
    private static int mt = 10;

    /**
     * @param Properties   item.properties
     * @param TipKey       string
     *                     <p>
     *                     traslation key for tooltips
     *                     <p>
     *                     it can be toggled off using `""`
     * @param scale        int [ x , y , z ]
     *                     <p>
     *                     spread radius
     * @param maxTry       int > 0
     *                     <p>
     *                     number of try to place before end
     * @param SoundEvent   soundevent
     * @param ParticleType particletype
     * @param BlocksPlace  tagkey< block >
     *                     <p>
     *                     blocks placed
     * @param BlockSoil    tagkey< block >
     *                     <p>
     *                     blocks checked below
     *                     <p>
     *                     it can be toggled to ANY using `null`
     * @param BlockReplace tagkey< block >
     *                     <p>
     *                     blocks checked replaced
     *                     <p>
     *                     it can be toggled DEFAULT using `null`
     */
    public SpecialBoneMeal(Properties Properties, String TipKey, int[] scale, int maxTry, SoundEvent SoundEvent,
            SimpleParticleType ParticleType, TagKey<Block> BlocksPlace, TagKey<Block> BlockSoil,
            TagKey<Block> BlockReplace) {
        super(Properties, TipKey);
        defineScale(scale);
        if (maxTry != 0)
            SpecialBoneMeal.mt = maxTry;
        SpecialBoneMeal.sd = SoundEvent;
        SpecialBoneMeal.pt = ParticleType;
        if (LevelUtil.getSizeTag(BlocksPlace) != 0)
            SpecialBoneMeal.bl = BlocksPlace;
        SpecialBoneMeal.bs = BlockSoil;
        if (BlockReplace != null)
            SpecialBoneMeal.br = BlockReplace;
    }

    @SuppressWarnings("null")
    public InteractionResult useOn(UseOnContext event) {

        Level level = event.getLevel();
        BlockPos pos = event.getClickedPos();
        Player player = event.getPlayer();
        ItemStack itemStack = player.getMainHandItem();

        if (!player.isCreative())
            itemStack.setCount(itemStack.getCount() - 1);

        tryPlace(level, pos);

        for (int i = 0; i < mt; i++) {
            BlockPos dynpos = new BlockPos(pos.getX() + MathUtil.rnd(-sx, sx),
                    pos.getY() + MathUtil.rnd(-sy, sy), pos.getZ() + MathUtil.rnd(-sz, sz));
            tryPlace(level, dynpos);
        }

        level.playLocalSound(pos.getX(), pos.getY(),
                pos.getZ(), sd, SoundSource.AMBIENT, 100,
                (float) MathUtil.rnd(0.1, 0.9), true);

        return InteractionResult.SUCCESS;
    }

    private void tryPlace(Level l, BlockPos p) {
        BlockState s = l.getBlockState(p);
        BlockState st = l.getBlockState(p.above());
        Block b = LevelUtil.ResourceByTag(bl, MathUtil.rnd(LevelUtil.getSizeTag(bl)));

        if (bs != null ? s.is(bs)
                : true && st.is(br)
                        && MathUtil.chance(75)) {
            l.setBlockAndUpdate(p.above(),
                    b.defaultBlockState());

        }
        if (MathUtil.chance(25))
            l.addParticle(pt, true, p.getX() + 0.5,
                    p.getY() + 1.75,
                    p.getZ() + 0.5, 0, 0, 0);

    }

    private void defineScale(int[] scale) {
        if (scale.length != 0) {
            SpecialBoneMeal.sx = scale[0];
            if (scale.length >= 2) {
                SpecialBoneMeal.sy = scale[1];
                if (scale.length >= 3)
                    SpecialBoneMeal.sz = scale[2];
            }
        }
    }
}
