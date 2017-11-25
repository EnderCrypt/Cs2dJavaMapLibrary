package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import net.ddns.endercypt.cs2dmap.library.file.read.Cs2dMapReader;
import net.ddns.endercypt.cs2dmap.library.file.stream.exception.Cs2dUnexpectedEOFException;
import net.ddns.endercypt.cs2dmap.library.file.write.Cs2dMapWriter;
import net.ddns.endercypt.cs2dmap.library.map.Cs2dMap;

public class LoadSaveMap
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		try
		{
			// test
			File file = new File("maps/test.map");
			Cs2dMap cs2dMap = Cs2dMapReader.read(file);
			Cs2dMapWriter.write(cs2dMap, file);

		}
		catch (Cs2dUnexpectedEOFException e)
		{
			System.err.println(e.getMessage());
			e.saveDebugByteString(new File("dump.txt"));
		}
		System.out.println("Done!");
	}
}
