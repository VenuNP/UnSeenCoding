package OnInheritance;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SwiggyItemSearch {
    public static void main(String[] args) {

        System.out.println(" Enter Search Item ");

        Scanner scanner = new Scanner(System.in);
        String item = scanner.next();


       Map<Integer,String> restaurantMap =  Restaurant.restaurants();

       List<Restaurant> restaurants =
               restaurantMap.keySet().stream()
                .map(id -> restaurantMap.get(id))
                .map(name -> Restaurant.getInstance(name))
                .collect(Collectors.toList());

     Map<Class,String> itemsSearch =  restaurants.stream()
                .filter(restaurant -> restaurant.items().containsKey(item))
                .collect(Collectors.toMap(restaurant -> restaurant.getClass(),
                        restaurant -> (item + " -> "+restaurant.items().get(item))));

     if(itemsSearch.size() == 0)
     {
         System.out.println(" Item not found \n Available Items");
         Map <Class, Map<String,Float>>  map =
                 restaurants.stream().collect(Collectors.toMap(restaurant -> restaurant.getClass(), restaurant -> restaurant.items()));
        System.out.println(map);
     }else
     {
         System.out.println(itemsSearch);
     }


    }
}

interface Restaurant
{
    public static final String CHICKEN_Biryani ="Chicken_Biryani";
    public static final String Veg_Biryani ="Veg_Biryani";
    public static final String Fish_Biryani ="Fish_Biryani";

    static Map<Integer,String> restaurants()
    {
        Map<Integer,String>  map = new LinkedHashMap<>();
        map.put(1, "OnInheritance.UrbanBlaze");
        map.put(2, "OnInheritance.EliteFlavours");
        map.put(3, "OnInheritance.Paradise");
        return map;
    }

    static List<String> search()
    {
        List<String> list = new ArrayList<>();
        list.add(CHICKEN_Biryani);
        list.add(Veg_Biryani);
        list.add(Fish_Biryani);
        return list;
    }

    static Restaurant getInstance(String name)
    {
        Restaurant restaurantRef = null;
        try
        {
            restaurantRef = (Restaurant) Class.forName(name).getDeclaredConstructor().newInstance();
        }catch (Exception exp)
        {
            exp.printStackTrace();
        }
       return restaurantRef;
    }

    Map<String,Float> items();
}

class UrbanBlaze implements Restaurant
{
    public Map<String,Float> items()
    {
        Map<String, Float> map = new LinkedHashMap<>();
        map.put(CHICKEN_Biryani,250f);
        map.put(Fish_Biryani,280f);

        return map;

    }
}

class EliteFlavours implements Restaurant
{
    public Map<String,Float> items()
    {
        Map<String, Float> map = new LinkedHashMap<>();
        map.put(CHICKEN_Biryani,250f);
        map.put(Veg_Biryani,280f);
        return map;

    }
}

class Paradise implements Restaurant {
    public Map<String, Float> items() {
        Map<String, Float> map = new LinkedHashMap<>();
        map.put(CHICKEN_Biryani, 250f);
        map.put(Fish_Biryani, 280f);
        map.put(Veg_Biryani, 220f);
        return map;
    }
}