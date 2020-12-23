//package mk.finki.ukim.mk.lab.bootstrap;
//
//import mk.finki.ukim.mk.lab.model.Balloon;
//import mk.finki.ukim.mk.lab.model.Manufacturer;
//import mk.finki.ukim.mk.lab.model.enumerations.BalloonStatus;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.IntStream;
////imitacija na baza/skladishte
//@Component
//public class DataHolder {
//    public static Map<Long, Balloon> balloonMap;
//    public static Map<Long, Manufacturer> manufacturerMap;
//    private static Long id = 1L;
//
//    @PostConstruct
//    public void init() {
//        manufacturerMap = new HashMap<>();
//        balloonMap = new HashMap<>();
//
//        IntStream.range(1, 6)
//                .forEach(i -> {
//                    Manufacturer manufacturer = new Manufacturer(
//                            generateId(),
//                            "Manufacturer"  + i,
//                            "Country" + i,
//                            "Address " + i
//                    );
//                    manufacturerMap.put(manufacturer.getId(), manufacturer);
//                });
//
//        IntStream.range(1, 11)
//                .forEach(i -> {
//                    Balloon b = new Balloon(generateId(), "balloonName" + i, "balloonDescription" + i, null, BalloonStatus.BIRTHDAY);
//                    balloonMap.put(b.getId(), b);
//                });
//    }
//
//    public static Long generateId() {
//        return id++;
//    }
//}
