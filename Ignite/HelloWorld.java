package com.biz.Ignite;

import java.util.Collection;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteException;
import org.apache.ignite.Ignition;
import org.apache.ignite.cluster.ClusterNode;
 
public class HelloWorld {
  public static void main(String[] args) throws IgniteException {
    try (Ignite ignite = Ignition.start()) {
    	
    	
    	ignite.cluster().active(true);
    	//Collection<ClusterNode> nodes = ignite.cluster().forServers().nodes();
    	//ignite.cluster().setBaselineTopology(nodes);
      // Put values in cache.
      IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache");
       
      cache.put(1, "Hello");
      cache.put(2, "World!");
 
      // Get values from cache and
      // broadcast 'Hello World' on all the nodes in the cluster.
      ignite.compute().broadcast(() -> {
        String hello = cache.get(1);
        String world = cache.get(2);
 
        System.out.println(hello + " " + world);
      });
    }
  }
}