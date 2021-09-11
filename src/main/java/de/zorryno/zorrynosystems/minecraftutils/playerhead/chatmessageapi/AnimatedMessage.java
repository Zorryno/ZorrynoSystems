package de.zorryno.zorrynosystems.minecraftutils.playerhead.chatmessageapi;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class AnimatedMessage {
    private ImageMessage[] images;
    private int index = 0;

    public AnimatedMessage(ImageMessage... images) {
        this.images = images;
    }

    public AnimatedMessage(File gifFile, int height, char imgChar) throws IOException {
        List<BufferedImage> frames = getFrames(gifFile);
        images = new ImageMessage[frames.size()];

        for(int i = 0; i < frames.size(); ++i) {
            images[i] = new ImageMessage(frames.get(i), height, imgChar);
        }

    }

    public List<BufferedImage> getFrames(File input) {
        ArrayList images = new ArrayList();

        try {
            ImageReader reader = ImageIO.getImageReadersBySuffix("GIF").next();
            ImageInputStream in = ImageIO.createImageInputStream(input);
            reader.setInput(in);
            int i = 0;

            for(int count = reader.getNumImages(true); i < count; ++i) {
                BufferedImage image = reader.read(i);
                images.add(image);
            }
        } catch (IOException var8) {
            var8.printStackTrace();
        }

        return images;
    }

    public ImageMessage current() {
        return images[index];
    }

    public ImageMessage next() {
        ++index;
        if (index >= images.length) {
            index = 0;
            return images[index];
        } else {
            return images[index];
        }
    }

    public ImageMessage previous() {
        --index;
        if (index <= 0) {
            index = images.length - 1;
            return images[index];
        } else {
            return images[index];
        }
    }

    public ImageMessage getIndex(int index) {
        return images[index];
    }

    public ImageMessage[] getImages() {
        return images;
    }

    public int size() {
        return images.length;
    }
}