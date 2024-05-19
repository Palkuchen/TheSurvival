package de.palkuchen.cakecloud.thesurvival.worldGen;

import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;

import java.util.Random;

public class CustomChunkGenerator extends ChunkGenerator {
    public CustomChunkGenerator() {
        // Set frequencies, lower frequency = slower change.


    }

    @Override
    public void generateNoise(WorldInfo worldInfo, Random random, int chunkX, int chunkZ, ChunkGenerator.ChunkData chunkData) {
        for(int y = -50; y < 50; y++) {
            for(int x = 0; x < 16; x++) {
                for(int z = 0; z < 16; z++) {
                    if (chunkX % 16 != 0 && chunkZ % 16 != 0) {

                    } else {
                        chunkData.setBlock(x, y, z, getBlock(x + (16 * chunkX), z + (16 * chunkZ), y, chunkData));
                    }
                }
            }
        }
    }

    Material getBlock(int x, int z, int y, ChunkGenerator.ChunkData chunkData) {
        // To seperate the generation of the different leyers
        double dis = distance(x, z, 0 , 0);

        return Material.AIR;
    }


    public static double distance(int OwnX, int OwnY, int SearchX, int SearchY) {
        return Math.sqrt((SearchY - OwnY) * (SearchY - OwnY) + (SearchX - OwnX) * (SearchX - OwnX));
    }
}
