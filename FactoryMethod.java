public abstract class ItemFactory 
{
    public abstract Item createItem();
}
public class BookFactory extends ItemFactory 
{
    @Override
    public Item createItem() 
    {
        return new Book();
    }
}
public class CDFactory extends ItemFactory 
{
    @Override
    public Item createItem() 
    {
        return new CD();
    }
}
public class DVDFactory extends ItemFactory 
{
    @Override
    public Item createItem() 
    {
        return new DVD();
    }
}