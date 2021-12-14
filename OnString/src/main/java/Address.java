public class Address  implements  Cloneable{
    private String city;

    public Address()
    {
    }
    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public  String toString()
    {
        return city;
    }

    public Address copyObject() throws CloneNotSupportedException
    {
        return (Address) super.clone();
    }
}
