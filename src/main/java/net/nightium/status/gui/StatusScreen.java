package net.nightium.status.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.nightium.status.Status;
import net.nightium.status.StatusClient;
import net.nightium.status.playerstate.Availability;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class StatusScreen extends StatusScreenBase {

    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Status.MODID, "textures/gui/gui_status.png");

    public StatusScreen() {
        super(Component.translatable("gui.status.title"), 145, 184);
    }

    @Override
    protected void init() {
        super.init();

        int x = guiLeft + 4 ;
        int y = guiTop + 7 + font.lineHeight + 7;
        int width = 137;
        int height = 20;

        StateButton neutral = new StateButton(x, y, width, height, Component.translatable("message.status.neutral"), "");
        addRenderableWidget(neutral);
        y += height + 1;

        StateButton recording = new StateButton(x, y, width, height, Component.translatable("message.status.recording"), "recording");
        addRenderableWidget(recording);
        y += height + 1;

        StateButton streaming = new StateButton(x, y, width, height, Component.translatable("message.status.streaming"), "streaming");
        addRenderableWidget(streaming);
        y += height + 5;
    }

    @Override
    public void renderBackground(GuiGraphics guiGraphics, int i, int j, float f) {
        super.renderBackground(guiGraphics, i, j, f);

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);
        guiGraphics.blit(TEXTURE, guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        int x = guiLeft + 10;
        int y = guiTop + 7 + font.lineHeight + 7;
        int height = 20;


        int titleWidth = font.width(getTitle());
        guiGraphics.drawString(font, getTitle(), guiLeft + (xSize - titleWidth) / 2, guiTop + 7, FONT_COLOR, false);
    }
}
