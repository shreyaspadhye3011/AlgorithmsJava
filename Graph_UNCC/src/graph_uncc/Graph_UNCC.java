/* Graph Representation, Structure Manipulation & Shotrtest Path (Dijkstra's)
 * 
 */

package graph_uncc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Comparator;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
// Used to signal violations of preconditions for
// various shortest path algorithms.
class GraphException extends RuntimeException
{
    public GraphException( String name )
    {
        super( name );
    }
}

// Represents a vertex in the graph.
class Vertex
{
    public String     name;   // Vertex name
    public List<Edge> adj;    // Adjacent vertices
    public Vertex     prev;   // Previous vertex on shortest path
    public double        dist;   // Distance of path

    
    public Vertex( String nm )
      { name = nm; adj = new LinkedList<Edge>( ); reset( ); }

    public void reset( )
      { dist = Graph_UNCC.INFINITY; prev = null; }    
      
}

class Edge
{
    public Vertex s_vertx;
    public Vertex d_vertx ;
    public double weight;
    public boolean updwn;
    
    public Edge(Vertex s,Vertex d, String wt)
    {
        s_vertx = s;
        d_vertx = d;
        weight = Double.parseDouble(wt);
    }        
}

// Graph class: evaluate shortest paths.
//
// CONSTRUCTION: with no parameters.
//
// ******************PUBLIC OPERATIONS**********************
// void addEdge( String v, String w )
//                              --> Add additional edge
// void printPath( String w )   --> Print path after alg is run
// void unweighted( String s )  --> Single-source unweighted
// ******************ERRORS*********************************
// Some error checking is performed to make sure graph is ok,
// and to make sure graph satisfies properties needed by each
// algorithm.  Exceptions are thrown if errors are detected.

public class Graph_UNCC 
{
   public static final int INFINITY = Integer.MAX_VALUE;
    private Map<String,Vertex> vertexMap = new HashMap<String,Vertex>( );

    /**
     * Add a new edge to the graph.
     */
    public void addEdgeinput( String sourceName, String destName, String wt )
    {
        Vertex v = getVertex( sourceName );
        Vertex w = getVertex( destName );
        Edge e = new Edge(v,w,wt);
        Edge e1 = new Edge(w,v,wt);
        v.adj.add(e);
        w.adj.add(e1);
    }
        

    /**
     * Driver routine to print total distance.
     * It calls recursive routine to print shortest path to
     * destNode after a shortest path algorithm has run.
     */
    public void printPath( String destName )
    {
        Vertex w = vertexMap.get( destName );
        if( w == null )
            throw new NoSuchElementException( "Destination vertex not found" );
        else if( w.dist == INFINITY )
            System.out.println( destName + " is unreachable" );
        else
        {
            System.out.print( "(Distance is: " + w.dist + ") " );
            printPath( w );
            System.out.println( );
        }
    }

    /**
     * If vertexName is not present, add it to vertexMap.
     * In either case, return the Vertex.
     */
    private Vertex getVertex( String vertexName )
    {
        Vertex v = vertexMap.get( vertexName );
        if( v == null )
        {
            v = new Vertex( vertexName );
            vertexMap.put( vertexName, v );
        }
        return v;
    }

    /**
     * Recursive routine to print shortest path to dest
     * after running shortest path algorithm. The path
     * is known to exist.
     */
    private void printPath( Vertex dest )
    {
        if( dest.prev != null )
        {
            printPath( dest.prev );
            System.out.print( " to " );
        }
        System.out.print( dest.name );
    }
    
    /**
     * Initializes the vertex output info prior to running
     * any shortest path algorithm.
     */
    private void clearAll( )
    {
        for( Vertex v : vertexMap.values( ) )
            v.reset( );
    }

    public void addEdge(String SourceName, String DestName, String edge_wt)
    {
        int edge_present = 0;
        Vertex a = getVertex(SourceName);
        Vertex b = getVertex(DestName);
        
        for(Iterator<Edge> i = a.adj.iterator(); i.hasNext();)
        {
            Edge ed = i.next();
            if(ed.s_vertx.equals(a) && ed.d_vertx.equals(b))
            {    
                ed.weight = Double.parseDouble(edge_wt);
                edge_present = 1;
            }   
        }    
        if (edge_present == 0)
        {
            Edge ed1 = new Edge(a,b,edge_wt);
            a.adj.add(ed1);
        } 
        //System.out.println("edge_flag: "+edge_present);
    }
    public void DeleteEdge(String SourceName, String DestName)
    {
        Vertex v = vertexMap.get( SourceName );
        Vertex w = vertexMap.get( DestName );
        if( v == null )
        {
            System.out.println("Vertex does not exists");
            return;
        }
        for(Iterator<Edge> i = v.adj.iterator(); i.hasNext();)
        {
            Edge ed = i.next();
            if(ed.s_vertx.equals(v) && ed.d_vertx.equals(w))
            {    
                v.adj.remove(ed); //throwing Exception. Use a flag value nd use remove() outside iterator loop
            }   
        }    
        
    }
    public void EdgeDown(String SourceName, String DestName)
    {
        
    }
    public void EdgeUp(String SourceName, String DestName)
    {
        
    }
    public void VertexDown(String SourceName)
    {
        
    }
    public void VertexUp(String sourceName)
    {
        
    }
     private HashMap<Integer,Vertex> map = new HashMap<Integer,Vertex>();
    
   public void Dijkstras(String SourceName, String DestName) 
   {
        clearAll(); 
        map.clear(); 
        double min_dist=0;
        ArrayList<Vertex> list = new ArrayList<Vertex>();
        Vertex start = vertexMap.get( SourceName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );
        
        start.dist=0;
        map.put(1,start);
        
        Set vertices = vertexMap.keySet();
        Iterator it=vertices.iterator();
        //System.out.println("Vertex map size: "+vertexMap.size());
        
        for(int i=2; i<=vertexMap.size(); i++) 
        {
         //   System.out.println("Flow..!");
            String vname = (String)it.next();       //IMP: This will only iterate the set of keys. As you can see that the iterator is on the keySet. Thus you'll have to use get() on these keys to get desired value.
            
            if(!((vertexMap.get(vname)).equals(start)))  //cz we alreday inserted start at the beginning
            {
                map.put(i,vertexMap.get(vname));
                System.out.println("Inserted [ "+vertexMap.get(vname).name+" ] at map index "+i);
            }
            else
                i--;
           
        }
        
        double current_dis=0;
        while(map.size()>=1)
        {
           // System.out.println("Flow..!");
//            Set vx = map.keySet();
//        Iterator it2=vx.iterator();
//        while(it2.hasNext())
//        {
//            Integer index=(Integer)it2.next();
//           // int index=Integer.parseInt(key);
//            //System.out.println(map.get(1).name);
//            System.out.println(map.get(index).name);
//        }
                Vertex v = map.get(1);
          System.out.println("Current Vertex: "+v.name);
            
//             Iterator it1 = v.adj.iterator();
//             while(it1.hasNext())
//             {
//                 Edge ed=(Edge)it1.next();
//                 System.out.println("Adjactent Vertex: "+ed.d_vertx.name);
//             }
            
            for( Edge w : v.adj)
            {
//                if(!(list.contains(v)))
//                {
                    current_dis = v.dist;
                    System.out.println("");
                    System.out.println("Adj Vertex: "+w.d_vertx.name+" dist: "+w.d_vertx.dist);
                    current_dis = current_dis + w.weight;
                    if(current_dis < w.d_vertx.dist)
                    {
                        w.d_vertx.dist = current_dis;
                        w.d_vertx.prev = v;
                        System.out.println(w.d_vertx.name+" dist updtaed as "+w.d_vertx.dist);
                        minHeapBalancing( w.d_vertx);
                 //   }
                }
                
            }
            map.remove(1);
            //list.add(v);
//            System.out.println("");
//            System.out.println("List Contents");
//            for(int i=0; i<list.size(); i++)
//            {
//                System.out.println(list.get(i).name);
//            }
            if(map.size()>=1)
                reHeapify();
        }
        
        Set vertices1 = vertexMap.keySet();
        Iterator itr=vertices1.iterator();
        System.out.println("");
        System.out.println("****************************************");
        for(int i=1; i<=vertexMap.size(); i++) 
        {
            String ver_name = (String)itr.next();
            System.out.println("Minimium distance of "+vertexMap.get(ver_name).name+" is [ "+vertexMap.get(ver_name).dist+" ]");
        } 
   }
   public void minHeapBalancing(Vertex currentVer) 
   {
//       Set key_Set = map.keySet();
//       Iterator it=key_Set.iterator();
      // System.out.println("");
       System.out.println("***min heap balancing call***");
       int i=1;
       int checkPos=1;
       while(i<=map.size())
       {
           Vertex v = (Vertex)map.get(i);
           if(v.equals(currentVer))
           {
               checkPos = i;
               System.out.println(currentVer.name+" positon spotted as "+checkPos);
               break;
           }
           i++;
       }
       if(checkPos==1)
           System.out.println("Vertex already Traversed");
       
       int parent_index=checkPos/2;
       int current_index=checkPos;
       if(map.get(parent_index).dist > map.get(current_index).dist)
       {
            while(parent_index >= 1)
            {
                if(map.get(parent_index).dist > map.get(current_index).dist)
                {
                    Vertex temp = map.get(parent_index);
                    map.put(current_index, temp);
                    map.put(parent_index, currentVer);
//                  // System.out.println("But Found smaller parent "+map.get(parent_index).weight+" at "+parent_index+" position");
//                  // System.out.println("Edge is: "+current_edge+" Switched to "+parent_index);
                    current_index = parent_index;
                    parent_index = parent_index/2;
                }
                else
                  break;
             System.out.println(currentVer.name+" positon changed as "+current_index);   
            }
       }  
   }
  
    public void reHeapify() 
    {
//        if(map.size()!=1)       //no need to heapify() when single element
//        {
            map.put(1, map.get(map.size()+1));      //size()+1 bcz we have removed front temporarily,so our last element is at size()+1 
            map.remove(map.size());                     //Imp: Once you place last element at first. Remove last element.
            int current_index = 1;
            int left_child_index = 2*current_index;
            int right_child_index = (2*current_index)+1;

            System.out.println("");
            System.out.println("Reheapify Call... at Map Size: "+map.size());
            System.out.println("Placed [ "+map.get(current_index).name+" ] at root");

            if(right_child_index <= map.size())
            {
                if((map.get(left_child_index).dist < map.get(current_index).dist || map.get(right_child_index).dist < map.get(current_index).dist)  )
                {
                    while(right_child_index <= map.size())
                    {
                        if(map.get(left_child_index).dist < map.get(current_index).dist || map.get(right_child_index).dist < map.get(current_index).dist )
                        {
                            if(map.get(left_child_index).dist < map.get(right_child_index).dist )
                            {
                                Vertex temp = map.get(left_child_index);
                                map.put(left_child_index, map.get(current_index));
                                map.put(current_index, temp);
                                current_index = left_child_index;
                            }
                            else
                            {
                                Vertex temp = map.get(right_child_index);
                                map.put(right_child_index, map.get(current_index));
                                map.put(current_index, temp);
                                current_index = right_child_index;
                            }
                             left_child_index = 2*current_index;
                             right_child_index = 2*current_index+1;
                        }
                        else
                            break;
                        System.out.println(map.get(current_index).name+" shifted to "+current_index);
                    }
                }
            }
          
    }
   
     //NOT IMPLEMENTED. Nowhere called.
//    public void Dijikstra(String SourceName, String DestName)
//    {
//         clearAll(); 
//         map.clear(); 
//         double min_dist=0;
//        Vertex start = vertexMap.get( SourceName );
//        if( start == null )
//            throw new NoSuchElementException( "Start vertex not found" );
//        
//       start.dist=0;
//       createMinHeap(start.adj);
//         Set keySet=map.keySet();
//         Iterator it=keySet.iterator();
//         System.out.println("Map Size is: "+map.size());
//         while(it.hasNext())
//         {
//             Object key = it.next();
//             System.out.println("Map Key: "+key+" Value: "+map.get(key).weight);
//         }
         
//       Edge temp = map.get(1);
//         min_dist = min_dist + map.get(1).weight;
//         map.get(1).d_vertx.prev = map.get(1).s_vertx;
//         System.out.println("Minimum distance edge is [ "+map.get(1).d_vertx.name+" ] With Weight: "+map.get(1).weight);
//         
        
//    }  
    
       //**Not Needed. Just done to check Min Heap Implementation
    
//     public void createMinHeap(List <Edge> a)
//     {   
//         int pos=1;
//         Iterator<Edge> it = a.iterator();
//         while (it.hasNext())
//         {
//             
//            Edge current_edge = (Edge)it.next();
//             //System.out.println("Current Edge is: "+current_edge.d_vertx.name);
//            if(pos==1)
//            {
//                map.put(1,current_edge);
//                //System.out.println("First Edge inserted: "+current_edge.d_vertx.name);
//                pos++;
//            }
//            else
//            {
//                map.put(pos, current_edge);
////                System.out.println("");
////                System.out.println("Inserted "+current_edge.d_vertx.name+" at "+pos+" position");
//                
//                int parent_index=pos/2;
//                int inserted_index=pos;
//              if(map.get(parent_index).weight > map.get(inserted_index).weight)
//              {
//                 
//                while(parent_index >= 1)
//                {
//                    if(map.get(parent_index).weight > map.get(inserted_index).weight)
//                    {
//                        Edge temp = map.get(parent_index);
//                        map.put(inserted_index, temp);
//                        map.put(parent_index, current_edge);
//                       // System.out.println("But Found smaller parent "+map.get(parent_index).weight+" at "+parent_index+" position");
//                       // System.out.println("Edge is: "+current_edge+" Switched to "+parent_index);
//                        inserted_index = parent_index;
//                        parent_index = parent_index/2;
//                    }
//                    else
//                        break;
//                  }
//                }
////              else
////                  map.put(pos, current_edge);
//                pos++;
//            }
//         }
//     }
    
    
    /**
     * Single-source unweighted shortest-path algorithm.
     */
/*    
    public void unweighted( String startName )
    {
        clearAll( ); 

        Vertex start = vertexMap.get( startName );
        if( start == null )
            throw new NoSuchElementException( "Start vertex not found" );

        Queue<Vertex> q = new LinkedList<Vertex>( );
        q.add( start ); start.dist = 0;

        while( !q.isEmpty( ) )
        {
            Vertex v = q.remove( );

            for( Vertex w : v.adj )
            {
                if( w.dist == INFINITY )
                {
                    w.dist = v.dist + 1;
                    w.prev = v;
                    q.add( w );
                }
            }
        }
    }

*/

    /**
     * Process a request; return false if end of file.
     */
    public boolean processRequest( Graph_UNCC g )
    {
        
        try
        {
//            System.out.print( "Enter start node: " );
//            String startName = in.nextLine( );

//            System.out.print( "Enter destination node: " );
//            String destName = in.nextLine( );

 //           g.unweighted( startName );
 //           g.printPath( destName );
          
            
         Set keys = g.vertexMap.keySet();
         Iterator itr = keys.iterator();
         
         while(itr.hasNext())
         {
             String key = (String)itr.next();
             System.out.println("Key: "+ key);
         }
            
         Map<String,Vertex> tmap = new TreeMap<String,Vertex>(vertexMap);
         System.out.println("After Sorting:");
         Set set2 = tmap.entrySet();
         Iterator itr2 = set2.iterator();
         while(itr2.hasNext())
         {
             Map.Entry m =(Map.Entry)itr2.next();
             //String akey = itr2.next();
             Vertex ver = (Vertex)m.getValue();
             //System.out.println("Name"+ver.name);
             List<Edge> edgelist = ver.adj;

             Collections.sort(edgelist, new Comparator<Edge>(){
             public int compare(Edge v1, Edge v2) {
             return (v1.d_vertx.name).compareTo(v2.d_vertx.name);
            }
            });
             Iterator<Edge> itr3 = edgelist.iterator();
             
             System.out.println(""+m.getKey().toString());
             while (itr3.hasNext())
             {
                 Edge adje = (Edge)itr3.next();
                 System.out.println(" "+adje.d_vertx.name+" "+adje.weight ); 
                 
             }    
         }    
            
        }
        catch( NoSuchElementException e )
          { return false; }
        catch( GraphException e )
          { System.err.println( e ); }
        
        return true;
        
    }

    /**
     * A main routine that:
     * 1. Reads a file containing edges (supplied as a command-line parameter);
     * 2. Forms the graph;
     * 3. Repeatedly prompts for two vertices and
     *    runs the shortest path algorithm.
     * The data file is a sequence of lines of the format
     *    source destination 
     */
    public static void main( String [ ] args )
    {
        Graph_UNCC g = new Graph_UNCC( );
        String s,start_ver,end_ver,link_wt;
        try
        {
            FileReader fin = new FileReader( args[0] );
            Scanner graphFile = new Scanner( fin );

            // Read the edges and insert
            String line;
            while( graphFile.hasNextLine( ) )
            {
                line = graphFile.nextLine( );
                StringTokenizer st = new StringTokenizer( line );

                try
                {
                    if( st.countTokens( ) != 3 )
                    {
                        System.err.println( "Skipping ill-formatted line " + line );
                        continue;
                    }
                    String source  = st.nextToken( );
                    String dest    = st.nextToken( );
                    String wt = st.nextToken( );
                    g.addEdgeinput( source, dest,wt );
                }
                catch( NumberFormatException e )
                  { System.err.println( "Skipping ill-formatted line " + line ); }
             }
         }
         catch( IOException e )
           { System.err.println( e ); }

         System.out.println( "File read..." );
         System.out.println( g.vertexMap.size( ) + " vertices" );
         Set keys = g.vertexMap.keySet();

         Scanner in = new Scanner( System.in );
        // g.processRequest( g );
         
         while(true)
         {    
         System.out.println( "Enter Query" );
         s = in.nextLine();
         String cmd[] = s.split(" ");
         switch(cmd[0])
         {
             case "print":
             {
                 g.processRequest( g );
                 break;
             }
             case "addedge" :
             {
                 if (cmd.length != 4)
                 {
                     System.err.println( "Skipping ill-formatted line " +cmd[0] );
                     break;
                 }    
                 start_ver = cmd[1];
                 end_ver = cmd[2];
                 link_wt = cmd[3];
                 g.addEdge(start_ver,end_ver,link_wt);
                 break;     
             }
             case "deleteedge" :
             {
                 if (cmd.length != 3)
                 {
                     System.err.println( "Skipping ill-formatted line " +cmd[0] );
                     break;
                 }
                 start_ver = cmd[1];
                 end_ver = cmd[2];
                 g.DeleteEdge(start_ver,end_ver);
                 break;
                 
                 
             }
             case "edgedown" :
             {
                 if (cmd.length != 3)
                 {
                     System.err.println( "Skipping ill-formatted line " +cmd[0] );
                     break;
                 }
                 start_ver = cmd[1];
                 end_ver = cmd[2];
                 g.EdgeDown(start_ver,end_ver);
                 break;
                 
             }
             case "edgeup":
             {
                 if (cmd.length != 3)
                 {
                     System.err.println( "Skipping ill-formatted line " +cmd[0] );
                     break;
                 }
                 start_ver = cmd[1];
                 end_ver = cmd[2];
                 g.EdgeUp(start_ver,end_ver);
                 break;
             }
             case "vertexdown" :
             {
                 if (cmd.length != 2)
                 {
                     System.err.println( "Skipping ill-formatted line " +cmd[0] );
                     break;
                 }
                 start_ver = cmd[1];
                 g.VertexDown(start_ver);
                 break;
             }
             case "vertexup" :
             {
                 if (cmd.length != 2)
                 {
                     System.err.println( "Skipping ill-formatted line " +cmd[0] );
                     break;
                 }
                 start_ver = cmd[1];
                 g.VertexUp(start_ver);
                 break;                 
             }    
             case "path" :
             {
                 if (cmd.length != 3)
                 {
                     System.err.println( "Skipping ill-formatted line " +cmd[0] );
                     break;
                 }
                 start_ver = cmd[1];
                 end_ver = cmd[2];
                 g.Dijkstras(start_ver,end_ver);
                 g.printPath(end_ver);
                // g.Dijikstra(start_ver,end_ver);
                 break;
             }
             case "reachable" :
             {
                 System.out.println("reachable");
                 break;
             }
             case "quit":
             {
                 System.exit(0);
                 break;
             }
             case "":
             {
                 System.out.println("Please enter a command");
                 break;
             }
             default:
             {
                 System.out.println("Incorrect Command");
                 break;
             }    
         } 
         
         
//         while( processRequest( in, g ) )
//             ;
         }   
    }

    

   

   

}
