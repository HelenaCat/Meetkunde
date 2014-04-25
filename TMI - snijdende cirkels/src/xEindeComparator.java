import java.util.Comparator;

public class xEindeComparator implements Comparator<Cirkel>
{
    @Override
    public int compare(Cirkel c1, Cirkel c2)
    {
        // ga ervan uit dat geen van beide cirkels == null
        if (c1.getXEinde() < c2.getXEinde())
        {
            return -1;
        }
        if (c1.getXEinde() > c2.getXEinde())
        {
            return 1;
        }
        return 0;
    }
}
