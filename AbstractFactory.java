public interface ItemMetadataFactory 
{
    public Metadata createMetadata();
}
public class BookMetadataFactory implements ItemMetadataFactory 
{
    @Override
    public Metadata createMetadata() 
    {
        return new BookMetadata();
    }
}
public class CDMetadataFactory implements ItemMetadataFactory 
{
    @Override
    public Metadata createMetadata() 
    {
        return new CDMetadata();
    }
}
public class DVDMetadataFactory implements ItemMetadataFactory 
{
    @Override
    public Metadata createMetadata() 
    {
        return new DVDMetadata();
    }
}