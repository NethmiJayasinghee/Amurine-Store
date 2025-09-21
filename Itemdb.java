package db;

public class Itemdb {
    private static Itemdb instance;
    private Itemdb(){

    }
    public static Itemdb getInstance(){
        return instance==null?instance=new Itemdb():instance;
    }
}
