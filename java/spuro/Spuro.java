/**
 * <p>Copyright: Copyright (c) 2019</p>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2019 by Jonatan Gomez-Perdomo. <br>
 * All rights reserved. <br>
 *
 * <p>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ul>
 * <li> Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <li> Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <li> Neither the name of the copyright owners, their employers, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * </ul>
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 *
 *
 * @author <A HREF="http://disi.unal.edu.co/profesores/jgomezpe"> Jonatan Gomez-Perdomo </A>
 * (E-mail: <A HREF="mailto:jgomezpe@unal.edu.co">jgomezpe@unal.edu.co</A> )
 * @version 1.0
 */
package spuro;

import java.util.HashMap;

/**
 * <p>Title: Spuro (Trace in Esperanto) </p>
 * <p>Tracing methods.</p>
 */
public class Spuro {
    protected static HashMap<Object, HashMap<Tracer,Tracer>> map =
	    new HashMap<Object, HashMap<Tracer,Tracer>>();
    
    /**
     * Adds a tracer to an object
     * @param owner Owner of the tracer
     * @param tracer Tracing method
     */
    public static void add(Object owner, Tracer tracer) {
    	HashMap<Tracer,Tracer> tracers = map.get(owner);
    	if( tracers == null ) {
    		tracers = new HashMap<Tracer,Tracer>();
    		map.put(owner,tracers);
    	}
    	tracers.put(tracer,tracer);
    }
    
    /**
     * Removes a tracer from an object
     * @param owner Owner of the tracer
     * @param tracer Tracing method
     */
    public static void del(Object owner, Tracer tracer) {
    	HashMap<Tracer,Tracer> tracers = map.get(owner);
    	if( tracers != null ) {
    		tracers.remove(tracer);
    		if( tracers.size() == 0 ) map.remove(owner);
    	}
    }
    
    /**
     * Traces information. Sends to all the tracers owned by object <i>owner</i> the traced information
     * @param owner Owner of the tracers
     * @param objects Traced information
     */
    public static void trace(Object owner, Object... objects ) {
    	HashMap<Tracer,Tracer> tracers = map.get(owner);
    	if( tracers != null )
    		for( Tracer t:tracers.keySet() ) t.add(owner, objects);
    }
}