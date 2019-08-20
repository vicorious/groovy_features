/**
 *
 */
class Student extends Person implements GroovyInterceptable
{
    protected dynamicProps=[:]


    int StudentID;
    String StudentName;

    int Marks1;
    int Marks2;
    int Marks3;

    /**
     *
     * @return
     */
    int Total()
    {
        return Marks1 + Marks2 + Marks3;
    }

    /**
     *
     */
    public Student()
    {
        super();
    }

    void setProperty(String pName,val)
    {
        dynamicProps[pName] = val
    }

    def getProperty(String pName)
    {
        dynamicProps[pName]
    }

    def invokeMethod(String name, Object args)
    {
        return "called invokeMethod $name $args"
    }
}