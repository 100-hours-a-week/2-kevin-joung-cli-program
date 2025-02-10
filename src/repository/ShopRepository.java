package repository;

import model.component.*;
import model.component.storage.HDD;
import model.component.storage.SSD;
import model.component.storage.Storage;

import java.util.List;

public class ShopRepository {
    public List<CPU> getCPUList() {
        return List.of(
                new CPU(
                        "i9 14900K",
                        697930,
                        253,
                        "Intel",
                        "인텔 소켓1700",
                        24,
                        32,
                        6.0
                ),
                new CPU(
                        "i7 14700K",
                        558540,
                        253,
                        "Intel",
                        "인텔 소켓1700",
                        20,
                        28,
                        5.6
                ),
                new CPU(
                        "i5 14400F",
                        198980,
                        148,
                        "Intel",
                        "인텔 소켓1700",
                        10,
                        16,
                        4.7
                ),
                new CPU(
                        "울트라7 시리즈2 265K",
                        1000000,
                        250,
                        "Intel",
                        "인텔 소켓1851",
                        24,
                        24,
                        5.7
                ),
                new CPU(
                        "라이젠7-5세대 7800X3D",
                        622590,
                        162,
                        "AMD",
                        "AMD 소켓AM5",
                        8,
                        16,
                        5.0
                ),
                new CPU(
                        "라이젠5-5세대 7500F",
                        220000,
                        88,
                        "AMD",
                        "AMD 소켓AM5",
                        6,
                        12,
                        5.0
                )
        );
    }

    public List<Mainboard> getMainboardList() {
        return List.of(
                new Mainboard(
                        "MSI Z790 EDGE WIFI",
                        369000,
                        120,
                        "MSI",
                        "인텔 소켓1700",
                        "Z790",
                        4
                ),
                new Mainboard(
                        "Gigabyte Z690 AORUS PRO",
                        389000,
                        130,
                        "Gigabyte",
                        "인텔 소켓1700",
                        "Z690",
                        4
                ),

                new Mainboard(
                        "ASRock Z690 Taichi",
                        499000,
                        140,
                        "ASRock",
                        "인텔 소켓1700",
                        "Z690",
                        4
                ),

                new Mainboard(
                        "인기 순위2 ASUS ROG STRIX B860-G GAMING WIFI",
                        330740,
                        160,
                        "ASUS",
                        "인텔 소켓1851",
                        "B860",
                        4
                ),

                new Mainboard(
                        "ASUS ROG STRIX B550-E GAMING",
                        299000,
                        110,
                        "ASUS",
                        "AMD 소켓AM5",
                        "B550",
                        4
                ),

                new Mainboard(
                        "MSI MAG B550 TOMAHAWK WIFI",
                        179000,
                        95,
                        "MSI",
                        "AMD 소켓AM5",
                        "B550",
                        4
                )
        );
    }

    public List<RAM> getRAMList() {
        return List.of(
                new RAM("Corsair Vengeance DDR5", 200000, 15, "Corsair", "DDR5", 16, 5200),
                new RAM("G.Skill Trident Z DDR5", 250000, 18, "G.Skill", "DDR5", 32, 6000),
                new RAM("Samsung DDR4", 80000, 10, "Samsung", "DDR4", 16, 3200),
                new RAM("Kingston Fury DDR4", 75000, 9, "Kingston", "DDR4", 8, 2666),
                new RAM("TeamGroup Elite DDR5", 180000, 12, "TeamGroup", "DDR5", 16, 4800)
        );
    }

    public List<GPU> getGPUList() {
        return List.of(
                new GPU("RTX 4090", 2199900, 450, "NVIDIA", 24),
                new GPU("RTX 4080", 1599900, 320, "NVIDIA", 16),
                new GPU("RTX 4070", 949000, 200, "NVIDIA", 12),
                new GPU("RX 7900 XTX", 1099900, 355, "AMD", 24),
                new GPU("RX 7800 XT", 749000, 263, "AMD", 16)
        );
    }

    public List<Storage> getStorageList() {
        return List.of(
                new SSD("Samsung 970 EVO Plus", 129000, 5, "Samsung", 500, "M.2", "NVMe"),
                new SSD("Western Digital Blue SN570", 95000, 4, "Western Digital", 250, "M.2", "NVMe"),
                new HDD("Seagate Barracuda", 85000, 6, "Seagate", 2000, 7200, 3.5),
                new HDD("Western Digital Blue", 50000, 4, "Western Digital", 1000, 5400, 2.5)
        );
    }

    public List<PowerSupply> getPowerSupplyList() {
        return List.of(
                new PowerSupply("Corsair RM750x", 145000, 15, "Corsair", 750),
                new PowerSupply("Seasonic Focus GX-650", 120000, 12, "Seasonic", 650),
                new PowerSupply("Cooler Master MWE Gold 550", 85000, 10, "Cooler Master", 550),
                new PowerSupply("EVGA SuperNOVA 1000 G6", 210000, 18, "EVGA", 1000),
                new PowerSupply("Thermaltake Smart RGB 700W", 95000, 14, "Thermaltake", 700)
        );
    }
}







