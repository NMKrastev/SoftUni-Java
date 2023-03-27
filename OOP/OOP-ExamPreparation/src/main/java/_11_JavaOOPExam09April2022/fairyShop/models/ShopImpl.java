package _11_JavaOOPExam09April2022.fairyShop.models;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        for (Instrument instrument : helper.getInstruments()) {
            while (!present.isDone() && helper.canWork() && !instrument.isBroken()) {
                present.getCrafted();
                helper.work();
                instrument.use();
            }
        }
    }
}
