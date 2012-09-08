/**
 * 
 */
package sandbox;

/**
 * @author Chris
 *
 */
class MemoryManager {
	final int coresize = 513; // actual size of the core (in 2-byte words)
    final int coreshift = 256; // shift of the core, to move the logical zero location away from the physical zero.  This allows negative addresses
	final short core[] = new short[coresize]; // the core
	
	public short Read(int address) throws MemoryManagerException
	{
		int realAddress;
		
		realAddress = address + coreshift;

		if (realAddress < 0 || realAddress >= coresize)
		{
			throw new MemoryManagerException();
		}
		
		return core[realAddress];
	}

	public void Write(int address, short value) throws MemoryManagerException
	{
		int realAddress;
		
		realAddress = address + coreshift;

		if (realAddress < 0 || realAddress >= coresize)
		{
			throw new MemoryManagerException();
		}
		
		core[realAddress] = value;
	}
}

class MemoryManagerException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
