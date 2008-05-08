/***************************************************************************
 *   Copyright (C) by Fabrizio Montesi                                     *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU Library General Public License as       *
 *   published by the Free Software Foundation; either version 2 of the    *
 *   License, or (at your option) any later version.                       *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU Library General Public     *
 *   License along with this program; if not, write to the                 *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 *                                                                         *
 *   For details about the authors of this software, see the AUTHORS file. *
 ***************************************************************************/

package jolie;

import jolie.process.CorrelatedProcess;
import jolie.process.Process;

public class SessionThread extends ExecutionThread implements Cloneable
{
	private jolie.State state;
	
	@Override
	public SessionThread clone()
	{
		SessionThread ret = new SessionThread( process, parent, notifyProc );
		ret.state = state.clone();
		for( Scope s : scopeStack )
			ret.scopeStack.push( s.clone() );
		return ret;
	}
	
	public void setState( jolie.State state )
	{
		this.state = state;
	}
	
	public SessionThread( Interpreter interpreter, Process process )
	{
		super( interpreter, process );
		state = new jolie.State();
	}
	
	public SessionThread( Process process, ExecutionThread parent, CorrelatedProcess notifyProc )
	{
		super( process, parent, notifyProc );

		assert( parent != null );
		
		state = parent.state().clone();
		for( Scope s : parent.scopeStack )
			scopeStack.push( s.clone() );
	}
	
	public jolie.State state()
	{
		return state;
	}
}
