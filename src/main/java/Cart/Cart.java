package Cart;

import java.util.HashMap;
import java.util.Map;

public class Cart
{
    private Map<String,Product> list = new HashMap<String, Product>();


    public void add(String name, Product item)
    {
        this.list.put(name, item);
    }

    public Map<String, Product> getList()
    {
        return list;
    }

    // Getters and setters.
    public int getSum()
    {
        int res = 0;
        for (Product product: this.getList().values())
        {
            res += product.getPrice();

        }
        return res;
    }
    public int getQuontity(){
        return this.getList().size();
    }

    public String print(){
        StringBuilder result = new StringBuilder();
        result.append("Number  || Name || Origin || Price");

        Integer count = 1;
        for(Product item: this.getList().values()){
            result.append(count.toString()+"|| "+item.getName()+" || "+item.getOrigin()+" || "+item.getPrice());
            count+=1;
        }


        return result.toString();
    }

    public String printToHtml(){
        StringBuilder result = new StringBuilder();
        result.append("Number  || Name || Origin || Price");

        Integer count = 1;
        for(Product item: this.getList().values()){
            result.append("<br>");
            result.append(count.toString()+"|| "+item.getName()+" || "+item.getOrigin()+" || "+item.getPrice());

            count+=1;
        }


        return result.toString();
    }



}
