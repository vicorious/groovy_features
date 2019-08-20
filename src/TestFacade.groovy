import java.awt.BorderLayout
import java.awt.GridLayout
import java.lang.management.ManagementFactory
import javax.management.ObjectName
import javax.swing.WindowConstants
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import groovy.sql.Sql
import groovy.swing.SwingBuilder
import groovy.xml.MarkupBuilder
import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl

/**
 *
 */
class TestFacade
{
    /**
     *
     */
    static def void dataTypeTest()
    {
        println("DataTypeTest init: ");
        //Example of a int datatype
        int x = 5;

        //Example of a long datatype
        long y = 100L;

        //Example of a floating point datatype
        float a = 10.56f;

        //Example of a double datatype
        double b = 10.5e40;

        //Example of a BigInteger datatype
        BigInteger bi = 30g;

        //Example of a BigDecimal datatype
        BigDecimal bd = 3.5g;

        println(x);
        println(y);
        println(a);
        println(b);
        println(bi);
        println(bd);

        println("DataTypeTest final ");
    }

    /**
     *
     */
    static def void rangeOperators()
    {
        println("rangeOperators init: ");

        def range = 5..10;
        println(range);
        println(range.get(2));

        println("rangeOperators final ");
    }

    /**
     *
     */
    static def void loops()
    {
        println("loops init: ");
        //While
        int count = 0;
        while(count<5)
        {
            println(count);
            count++;
        }
        //For
        for(int i = 0;i<5;i++)
        {
            println(i);
        }
        //For in
        int[] array = [0,1,2,3];
        for(int i in array)
        {
            println(i);
        }

        println("loops final ");
    }

    /**
     *
     * @param a
     * @param b
     */
    static void defaultParameters(int a,int b = 5)
    {
        println("defaultParameters init: ");

        int c = a+b;
        println(c);

        println("defaultParameters final ");
    }

    /**
     *
     */
    static int _return(int a,int b = 5)
    {
        println("_return init: ");
        int c = a+b;
        return c;
        println("_return final ");
    }

    /**
     *
     */
    static void instanceMethod()
    {
        println("instanceMethod init: ");

        Example ex = new Example();
        ex.setX(100);
        println(ex.getX());

        println("instanceMethod final ");
    }

    /**
     *
     */
    static void readFile()
    {
        println("readFile init: ");

        new File("C:/Users/alindartec/Documents/Example.txt").eachLine
        {
            line -> println "line : $line";
        }

        println("readFile final ");
    }

    /**
     *
     */
    static void readFileAsEntireString()
    {
        println("readFileAsEntireString init: ");

        File file = new File("C:/Users/alindartec/Documents/Example.txt")
        println file.text

        println("readFileAsEntireString final ");
    }

    /**
     *
     */
    static void writeFile()
    {
        println("writeFile init: ");

        new File('C:/Users/alindartec/Documents/','Example.txt').withWriter('utf-8')
        {
            writer -> writer.writeLine 'Hello World'
        }

        println("writeFile final ");

    }

    /**
     *
     */
    static void sizeFromFile()
    {
        println("sizeFromFile init: ");

        File file = new File("C:/Users/alindartec/Documents/Example.txt")
        println "The file ${file.absolutePath} has ${file.length()} bytes"

        println("sizeFromFile final ");
    }

    /**
     *
     */
    static void fileIsDirectory()
    {
        println("fileIsDirectory init: ");

        def file = new File('C:/')
        println "File? ${file.isFile()}"
        println "Directory? ${file.isDirectory()}"

        println("fileIsDirectory final ");
    }

    /**
     *
     */
    static void createDirectory()
    {
        println("createDirectory init: ");

        def file = new File('C:/Directory')
        file.mkdir()

        println("createDirectory final ");
    }

    /**
     *
     */
    static void deleteFile()
    {
        println("deleteFile init: ");

        def file = new File('C:/Example.txt')
        file.delete()

        println("deleteFile final ");
    }

    /**
     *
     */
    static void copyFile()
    {
        println("copyFile init: ");

        def src = new File("C:/Example.txt")
        def dst = new File("C:/Example1.txt")
        dst << src.text

        println("copyFile final ");
    }

    /**
     *
     */
    static void directoryContents()
    {
        println("directoryContents init: ");

        def rootFiles = new File("test").listRoots()
        rootFiles.each
        {
            file -> println file.absolutePath
        }

        println("directoryContents init: ");
    }

    /**
     *
     */
    static void directoryContent(boolean _recurso = true)
    {
        println("directoryContent init: ");

        if(_recurso)
        {
            new File("C:/temp").eachFileRecurse()
            {
                file -> println file.getAbsolutePath()
            }
        }else
        {
            new File("C:/Temp").eachFile()
            {
                file->println file.getAbsolutePath()
            }
        }
        println("directoryContent final ");
    }

    /**
     *
     */
    static void typing()
    {
        println("typing init: ");

        // Example of an Integer using def
        def a = 100;
        println(a);

        // Example of an float using def
        def b = 100.10;
        println(b);

        // Example of an Double using def
        def c = 100.101;
        println(c);

        // Example of an String using def
        def d = "HelloWorld";
        println(d);

        println("typing final ");
    }

    /**
     *
     */
    static void numberBoxing()
    {
        println("boxing init: ");

        Integer x = 5,y = 10,z = 0;
        // The the values of 5,10 and 0 are boxed into Integer types
        // The values of x and y are unboxed and the addition is performed
        z = x+y;
        println(z);

        println("boxing final ");
    }

    /**
     *
     */
    static void string()
    {
        println("string init: ");

        String a = 'Hello Single';
        String b = "Hello Double";
        String c = "'Hello Triple" + "Multiple lines'";

        println(a);
        println(b);
        println(c);

        println("string final ");
    }

    /**
     *
     */
    static void stringIndexing()
    {
        println("stringIndexing init: ");

        String sample = "Hello world";
        println(sample[4]); // Print the 5 character in the string

        //Print the 1st character in the string starting from the back
        println(sample[-1]);
        println(sample[1..2]);//Prints a string starting from Index 1 to 2
        println(sample[4..2]);//Prints a string starting from Index 4 back to 2

        println("stringIndexing final ");
    }

    /**
     *
     */
    static void ranges()
    {
        println("ranges init: ");

        def inclusive_range  = 1..10;
        def exclusive_range  = 1..<10;
        def characters_range = 'a'..'x';
        def descending_order = 10..1;
        def characters_descending_range = 'x'..'a';

        println("ranges final ");
    }

    /**
     *
     */
    static void list()
    {
        println("list init: ");

        def integer_list  = [11, 12, 13, 14];
        def string_list  = ['Angular', 'Groovy', 'Java'];
        def nested_list = [1, 2, [3, 4], 5] ;
        def heterogeneous_list = ['Groovy', 21, 2.11];
        def empty_list = [];

        println("list final ");
    }

    /**
     *
     */
    static void map()
    {
        println("map init: ");

        def map = ['TopicName' : 'Lists', 'TopicName' : 'Maps']
        def empty_map = [:];

        println("map final ");

    }

    /**
     *
     */
    static void dateAndTimes()
    {
        println("dateAndTimes init: ");

        //Default date
        Date date = new Date();
        System.out.println(date.toString());
        // Long time
        Date dateLong = new Date(100);
        System.out.println(dateLong.toString());

        println("dateAndTimes final ");

    }

    /**
     *
     */
    static void regex()
    {
        println("regex init: ");

        def regex = ~'Groovy'

        println("regex final ");
    }

    /**
     *
     */
    static void exceptionHandling()
    {
        println("exceptionHandling init: ");

        try
        {
            def arr = new int[3];
            arr[5] = 5;

        } catch(ArrayIndexOutOfBoundsException ex)
        {
            println(ex.toString());
            println(ex.getMessage());
            println(ex.getStackTrace());
        } catch(Exception ex)
        {
            println("Catching the exception");

        } finally
        {
            println("The final block");
        }

        println("exceptionHandling final ");
    }

    /**
     *
     */
    static void objectOriented()
    {
        println("objectOriented init: ");

        Student student = new Student();

        println("objectOriented final ");
    }

    /**
     *
     */
    static void interfaceOriented()
    {
        println("interfaceOriented init: ");

        Person persona = new Person();

        println("interfaceOriented final ");
    }

    /**
     *
     */
    static void generalizedClasses()
    {
        println("generalizedClasses init: ");

        ListType<String> lststr = new ListType<>();
        lststr.set("First String");
        println(lststr.get());

        ListType<Integer> lstint = new ListType<>();
        lstint.set(1);
        println(lstint.get());

        println("generalizedClasses final ");
    }

    /**
     *
     */
    static void traits()
    {
        println("traits init: ");

        StudentTrait st = new StudentTrait();
        st.StudentID = 1;
        st.Marks1 = 10;
        println(st.DisplayMarks());

        println("traits final ");
    }

    /**
     *
     */
    static void closures()
    {
        println("closures init: ");

        def clos = {println "Hello World"};
        clos.call();
        //Formal parameters
        def clos1 = {param->println "Hello ${param}"};
        clos1.call("World");

        //Closures and variables
        def str1 = "Hello";
        def clos2 = {param -> println "${str1} ${param}"}
        clos2.call("World");

        // We are now changing the value of the String str1 which is referenced in the closure
        str1 = "Welcome";
        clos2.call("World");

        //Closures and Methods
        def str11 = "Hello";
        def clos4 = { param -> println "${str11} ${param}" }
        clos4.call("World");

        // We are now changing the value of the String str1 which is referenced in the closure
        str11 = "Welcome";
        clos4.call("World");
        // Passing our closure to a method
        Example.Display(clos);

        //List and closures
        def lst = [11, 12, 13, 14];
        lst.each {println it}

        //Closures with maps
        def mp = ["TopicName" : "Maps", "TopicDescription" : "Methods in Maps"]
        mp.each {println it}
        mp.each {println "${it.key} maps to: ${it.value}"}

        println("closures final ");
    }

    /**
     *
     * @param clo
     * @return
     */
    def static DisplayClosure(clo)
    {
        // This time the $param parameter gets replaced by the string "Inner"
        clo.call("Inner");
    }

    /**
     *
     */
    static void annotations()
    {
        println("annotations init: ");

        def user = new User(username: "Joe",age:1);
        println(user.age);
        println(user.username);

        println("annotations final ");
    }

    /**
     *
     */
    static void createXml()
    {
        println("createXml init: ");

        def mB = new MarkupBuilder();
        // Compose the builder
        mB.collection(shelf : 'New Arrivals')
        {
            movie(title : 'Enemy Behind')
            type('War, Thriller')
            format('DVD')
            year('2003')
            rating('PG')
            stars(10)
            description('Talk about a US-Japan war')
        }

        println("createXml final ");
    }

    /**
     *
     */
    static void xmlParsing()
    {
        println("xmlParsing init: ");

        def parser = new XmlParser()
        def doc = parser.parse("C:\\init.xml");

        doc.movie.each
        {
            bk ->
                print("Movie Name:")
                println "${bk['@title']}"

                print("Movie Type:")
                println "${bk.type[0].text()}"

                print("Movie Format:")
                println "${bk.format[0].text()}"

                print("Movie year:")
                println "${bk.year[0].text()}"

                print("Movie rating:")
                println "${bk.rating[0].text()}"

                print("Movie stars:")
                println "${bk.stars[0].text()}"

                print("Movie description:")
                println "${bk.description[0].text()}"
                println("*******************************")
        }

        println("xmlParsing final ");

    }

    /**
     *
     */
    static void monitoringJVM()
    {
        println("monitoringJVM init: ");

        def os = ManagementFactory.operatingSystemMXBean
        println """OPERATING SYSTEM: 
                \tOS architecture = $os.arch 
                \tOS name = $os.name 
                \tOS version = $os.version 
                \tOS processors = $os.availableProcessors 
                """

        def rt = ManagementFactory.runtimeMXBean
        println """RUNTIME: 
                \tRuntime name = $rt.name 
                \tRuntime spec name = $rt.specName 
                \tRuntime vendor = $rt.specVendor 
                \tRuntime spec version = $rt.specVersion 
                \tRuntime management spec version = $rt.managementSpecVersion 
                """

        def mem = ManagementFactory.memoryMXBean
        def heapUsage = mem.heapMemoryUsage
        def nonHeapUsage = mem.nonHeapMemoryUsage

        println """MEMORY: 
                HEAP STORAGE: 
                \tMemory committed = $heapUsage.committed 
                \tMemory init = $heapUsage.init 
                \tMemory max = $heapUsage.max 
                \tMemory used = $heapUsage.used NON-HEAP STORAGE: 
                \tNon-heap memory committed = $nonHeapUsage.committed 
                \tNon-heap memory init = $nonHeapUsage.init 
                \tNon-heap memory max = $nonHeapUsage.max 
                \tNon-heap memory used = $nonHeapUsage.used 
                """

        println "GARBAGE COLLECTION:"
        ManagementFactory.garbageCollectorMXBeans.each
        {
            gc ->
                println "\tname = $gc.name"
                println "\t\tcollection count = $gc.collectionCount"
                println "\t\tcollection time = $gc.collectionTime"
                String[] mpoolNames =   gc.memoryPoolNames

                mpoolNames.each
                {
                    mpoolName -> println "\t\tmpool name = $mpoolName"
                }
        }

        println("monitoringJVM final ");
    }

    /**
     *
     */
    static void parsingJSON()
    {
        println("parsingJSON init: ");

        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parseText('{ "name": "John", "ID" : "1"}')

        println(object.name);
        println(object.ID);

        println("parsingJSON final ");
    }

    /**
     *
     */
    static void parsingJSONList()
    {
        println("parsingJSONList init: ");

        def jsonSlurper = new JsonSlurper()
        Object lst = jsonSlurper.parseText('{ "List": [2, 3, 4, 5] }')
        lst.each { println it }

        println("parsingJSONList final ");
    }

    /**
     *
     */
    static void toJson()
    {
        println("toJson init: ");

        def output = JsonOutput.toJson([name: 'John', ID: 1])
        println(output);

        println("toJson final ");
    }

    /**
     *
     */
    static void objectToJsonObject()
    {
        println("objectToJsonObject init: ");

        def output = JsonOutput.toJson([ new Student(name: 'John',ID:1),
                                         new Student(name: 'Mark',ID:2)])
        println(output);

        println("objectToJsonObject final ");
    }

    /**
     *
     */
    static void DSL()
    {
        println("DSL init: ");

        EmailDSL.make
        {
            to "Nirav Assar"
            from "Barack Obama"
            body "How are things? We are doing well. Take care"
        }

        println("DSL final ");
    }

    /**
     *
     */
    static void SQL()
    {
        // Creating a connection to the database
        def sql = Sql.newInstance('jdbc:mysql://localhost:5432/postgres',
                                  'postgres', '*postgre123*', 'org.postgresql.Driver')
        sql.eachRow('SELECT SYSDATE')
            {
                row
                    ->
                    println row[0]
            }
        sql.close()
    }

    /**
     *
     *
     */
    static void insertSQL()
    {
        // Creating a connection to the database
        def sql = Sql.newInstance('jdbc:mysql://localhost:3306/TESTDB', 'testuser',
                                  'test123', 'com.mysql.jdbc.Driver')

        sql.connection.autoCommit = false

        def sqlstr = """INSERT INTO CUSTOMER (ID, NAME, LAST_NAME, IDENTIFICATION) VALUES (NULL, 'Joel', 'Vargas Lindarte','123123123')"""
        try
        {
            sql.execute(sqlstr);
            sql.commit()
            println("Successfully committed")

        }catch(Exception ex)
        {
            sql.rollback()
            println("Transaction rollback")
        }

        sql.close()

    }

    /**
     *
     */
    static void swingBuilder()
    {
        def myapp = new SwingBuilder()

        def buttonPanel = {
            myapp.panel(constraints : BorderLayout.SOUTH) {

                button(text : 'Option A', actionPerformed : {
                    println 'Option A chosen'
                })

                button(text : 'Option B', actionPerformed : {
                    println 'Option B chosen'
                })
            }
        }

        def mainPanel = {
            myapp.panel(layout : new BorderLayout()) {
                label(text : 'Which Option do you want', horizontalAlignment :
                    JLabel.CENTER,
                      constraints : BorderLayout.CENTER)
                buttonPanel()
            }
        }

        def myframe = myapp.frame(title : 'Tutorials Point', location : [100, 100],
                                  size : [400, 300], defaultCloseOperation : WindowConstants.EXIT_ON_CLOSE){
            mainPanel()
        }

        myframe.setVisible(true)
    }

    /**
     *
     */
    static void DOMBuilder()
    {
        String records = '''
            <library>	
                <Student>
                    <StudentName division = 'A'>Joe</StudentName>
                    <StudentID>1</StudentID>
                </Student>	  
                <Student>
                    <StudentName division = 'B'>John</StudentName>
                    <StudentID>2</StudentID>
                </Student>        	  
                <Student>
                    <StudentName division = 'C'>Mark</StudentName>
                    <StudentID>3</StudentID>
                </Student>		
            </library>'''
        def rd = new StringReader(records)
        def doc = groovy.xml.DOMBuilder.parse(rd)
    }

    /**
     *
     */
    static void JSONBuilder()
    {
        def builder = new groovy.json.JsonBuilder()

        def root = builder.students {
            student {
                studentname 'Joe'
                studentid '1'

                Marks(
                    Subject1: 10,
                    Subject2: 20,
                    Subject3:30,
                    )
            }
        }
        println(builder.toString());
    }

    /**
     *
     */
    static void NodeBuilder()
    {
        def nodeBuilder = new NodeBuilder()

        def studentlist = nodeBuilder.userlist
        {
            user(id: '1', studentname: 'John', Subject: 'Chemistry')
            user(id: '2', studentname: 'Joe', Subject: 'Maths')
            user(id: '3', studentname: 'Mark', Subject: 'Physics')
        }

        println(studentlist)
    }

    /**
     *
     */
    static void FileTreeBuilder()
    {
        def tmpDir = File.createTempDir()
        def fileTreeBuilder = new FileTreeBuilder(tmpDir)

        fileTreeBuilder.dir('main')
        {
            dir('submain')
            {
                dir('Tutorial')
                {
                    file('Sample.txt', 'println "Hello World"')
                }
            }
        }

    }

    /**
     *
     */
    static void reflection()
    {
        // Missing Property
        Student mst = new Student();
        mst.Name = "Joe";
        mst.ID = 1;

        println(mst.Name);
        println(mst.ID);

        // Missing Methods
        Student mst1 = new Student();
        mst1.Name = "Joe";
        mst1.ID = 1;

        println(mst1.Name);
        println(mst1.ID);
        mst1.AddMarks();

        //Metaclass
        Student mst2 = new Student();
        println mst2.getName()
        mst2.metaClass.setAttribute(mst, 'name', 'Mark')
        println mst2.getName()

    }

}
