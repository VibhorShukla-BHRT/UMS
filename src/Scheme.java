package src;

public abstract class Scheme {
    public boolean isLoggedIN = false;
    final long id;
    public final String name;
    public String address;
    public long mob;
    public Scheme(String name, String address, long mob){
        this.name = name;
        this.address = address;
        this.mob = mob;
        this.id = System.currentTimeMillis();
    }
    public long getId(){
        return this.id;
    }

}
