package service;

import model.component.*;
import model.component.storage.Storage;
import repository.ShopRepository;

import java.util.List;

public class ShopService {
    private ShopRepository shopRepository = new ShopRepository();

    public List<CPU> getCPUList() {
        return shopRepository.getCPUList();
    }

    public List<Mainboard> getMainboardList() {
        return shopRepository.getMainboardList();
    }

    public List<RAM> getRAMList() {
        return shopRepository.getRAMList();
    }

    public List<GPU> getGPUList() {
        return shopRepository.getGPUList();
    }

    public List<Storage> getStorageList() {
        return shopRepository.getStorageList();
    }

    public List<PowerSupply> getPowerSupplyList() {
        return shopRepository.getPowerSupplyList();
    }

    // 컴포넌트 리스트의 총 전력 요구량을 리턴
    public int calcTotalWattage(List<Component> components) {
        int totalWattage = 0;
        for (Component component : components) {
            totalWattage += component.powerConsumption;
        }
        return totalWattage;
    }

    // 컴포넌트 리스트의 총 가격을 리턴
    public int calcTotalPrice(List<Component> components) {
        int totalPrice = 0;
        for (Component component : components) {
            totalPrice += component.price;
        }
        return totalPrice;
    }

}
