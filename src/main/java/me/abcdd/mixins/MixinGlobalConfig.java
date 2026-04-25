package me.abcdd.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.jackhuang.hmcl.setting.GlobalConfig;

@Mixin(GlobalConfig.class)
public class MixinGlobalConfig {

    @Shadow
    @Mutable
    @Final
    private BooleanProperty enableOfflineAccount;

    /**
     * 构造函数注入，在 GlobalConfig 构造时替换 enableOfflineAccount 字段初值为 true
     */
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(CallbackInfo ci) {
        this.enableOfflineAccount = new SimpleBooleanProperty(true);
    }
}