package de.zorryno.zorrynosystems.minecraftutils;

import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.Metadatable;
import org.bukkit.plugin.Plugin;

public class MetaData{

    /**
     * Gets a metadata value in the implementing object's metadata store.
     *
     * @param target the {@link Object} on which the metadata are assigned
     * @param key A unique key to identify this metadata.
     *
     * @throws IllegalArgumentException If target don't implements Metadatable
     *
     * @return The assigned {@link Object}
     */
    public static Object getMetaData(Object target, String key) {
        if(!(target instanceof Metadatable)) {
            throw new IllegalArgumentException("Object target don't implements Metadatable");
        }
        if(hasMetaData(target, key)) {
            return ((Metadatable) target).getMetadata(key).get(0).value();
        } else {
            return null;
        }
    }

    /**
     * Sets a metadata value in the implementing object's metadata store.
     *
     * @param plugin the {@link Plugin} that created this metadata value
     * @param target the {@link Object} to which the Metadata will assigned
     * @param key A unique key to identify this metadata.
     * @param saveObject the {@link Object} assigned to this metadata value
     *
     * @throws IllegalArgumentException If target don't implements Metadatable
     */
    public static void setMetaData(Plugin plugin, Object target, String key, Object saveObject) {
        if(!(target instanceof Metadatable)) {
            throw new IllegalArgumentException("Object target don't implements Metadatable");
        }

        if(((Metadatable) target).hasMetadata(key)) {
            ((Metadatable) target).removeMetadata(key, plugin);
        }
        ((Metadatable) target).setMetadata(key, new FixedMetadataValue(plugin, saveObject));
    }

    /**
     * Tests to see whether the implementing object contains the given
     * metadata value in its metadata store.
     *
     * @param target the {@link Object} to check if the metadata is assigned
     * @param key the unique metadata key being queried.
     *
     * @throws IllegalArgumentException If target don't implements Metadatable
     *
     * @return the existence of the metadataKey within subject.
     */
    public static boolean hasMetaData(Object target, String key) {
        if(!(target instanceof Metadatable)) {
            throw new IllegalArgumentException("Object target don't implements Metadatable");
        }
        return ((Metadatable) target).hasMetadata(key);
    }

    /**
     * Remove a metadata value in the implementing object's metadata store.
     *
     * @param plugin the {@link Plugin} that removed this metadata value
     * @param target the {@link Object} from which the Metadata will be removed
     * @param key the unique metadata key being queried.
     *
     * @throws IllegalArgumentException If target don't implements Metadatable
     *
     * @return true if the metadata value is removed, otherwise false.
     */
    public static boolean removeMetaData(Plugin plugin, Object target, String key) {
        if(!(target instanceof Metadatable)) {
            throw new IllegalArgumentException("Object target don't implements Metadatable");
        }

        if(((Metadatable) target).hasMetadata(key)) {
            ((Metadatable) target).removeMetadata(key, plugin);
            return true;
        }
        return false;
    }
}