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

import lifya.stringify.Stringifier;

/**
 *
 * <p>Title: OutputStreamTracer</p>
 * <p>Description: A Tracer based on OuptputStream (stores traced object information in the provided OutputStream).</p>
 */
public abstract class OutputStreamTracer implements Tracer {	
	/**
	 * Determines if a new line symbol is added after tracing an object
	 */
	protected boolean addNewLine = true;

	/**
	 * Determines if a new line symbol is added after tracing an object
	 */
	protected char SEPARATOR = ' ';

	/**
	 * Creates an output stream (writes a data object per line)
	 */
	public OutputStreamTracer(){}

	/**
	 * Creates an output stream tracer
	 * @param SEPARATOR Symbol used for separating objects
	 */
	public OutputStreamTracer( char SEPARATOR ) { this.SEPARATOR = SEPARATOR; }

	/**
	 * Creates an output stream tracer
	 * @param addNewLine Determines if a new line symbol is added after tracing an object
	 */
	public OutputStreamTracer( boolean addNewLine ) { this.addNewLine = addNewLine; }

	/**
	 * Creates an OutputStream tracer
	 * @param SEPARATOR Character used for separating traced values.
	 * @param addNewLine Determines if a new line symbol is added after tracing an object
	 */
	public OutputStreamTracer( char SEPARATOR, boolean addNewLine ) { this.addNewLine = addNewLine; }
    
	/**
	 * Writes an object (String) to the Tracer.
	 * @param str Object to be traced.
	 */
	public abstract void write( String str );

	/**
	 * Adds the traced information sent by the caller object to the Output Stream
	 * @param caller Object calling the tracing method
	 * @param obj Traced information 
	 */
	@Override
	public void add(Object caller, Object... obj) {
		if( obj.length > 0 ){
			write(SEPARATOR+Stringifier.apply(obj[0]));
			for( int i=1; i<obj.length; i++ ) write(SEPARATOR+Stringifier.apply(obj[i]));
			if( addNewLine ) write("\n");
		}
	}

	/**
	 * Return the traced information
	 * @return null since the Output Stream does not store the traced information
	 */
	@Override
	public Object get() { return null; }    
}