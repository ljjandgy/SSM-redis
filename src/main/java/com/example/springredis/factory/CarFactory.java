package com.example.springredis.factory;

/**
 * 普通工厂模式示例类(让开发者通过传入汽车类型直接从工厂中获取相应的汽车对象，这样就不用开发者去了解具体的汽车对象了)
 */
public class CarFactory implements ICarFactory{
    /**
     * 生产中档车
     * @param carType
     * @return
     */
    public ICar createCar(String carType){
        switch (carType){
            case "1": return new Car1();
            case "2": return new Car2();
            case "3": return new Car3();
            case "4": return new Car4();
            default: throw new RuntimeException("没有找到相应的汽车类型，请重新输入！");
        }
    }
}
