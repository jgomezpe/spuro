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
import java.io.IOException;

import speco.array.Array;

/**
 * <p>A tracer that stores traced information in an Array.</p>
 *
 */
public class ArrayTracer implements Tracer {
	/**
	 * Traced information
	 */
	private Array<Object[]> object = new Array<Object[]>();
	
	private int each=1;
	private int count = 0;

	/**
	 * Creates a new SingleResultTracer
	 */
	public ArrayTracer(){}

	/**
	 * Creates a new SingleResultTracer
	 * @param each Sampling rate. Number of times the method adds is called befor adding traced information to the array
	 */
	public ArrayTracer( int each ){ this.each=each; }

	/**
	 * Adds the traced information sent by the caller object
	 * @param caller Object calling the tracing method
	 * @param obj Traced information 
	 */
	public void add(Object caller, Object... obj){
		count = (count+1)%each;
		if( count==0 ) object.add(obj);
	}

	/**
	 * Returns the traced information
	 * @return A single object representing the traced information
	 */
	public Object get(){ return object; }

	/**
	 * Closes the tracer (does nothing)
	 * @throws IOException if the collection cannot be closed
	 */
	public void close() throws IOException {};
	
	/**
	 * Cleans the traced information
	 */
	@Override
	public void clear() { object.clear(); }	
}