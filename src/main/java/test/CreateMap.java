package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import net.ddns.endercypt.cs2dmap.library.file.stream.exception.Cs2dUnexpectedEOFException;
import net.ddns.endercypt.cs2dmap.library.file.write.Cs2dMapWriter;
import net.ddns.endercypt.cs2dmap.library.map.Cs2dMap;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info.Info_CT;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info.Info_Hostage;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info.Info_T;
import net.ddns.endercypt.cs2dmap.library.map.obj.entity.type.info.Info_Hostage.HostageLooks;
import net.ddns.endercypt.cs2dmap.library.map.obj.tile.modifier.ColorTileModifier;
import net.ddns.endercypt.cs2dmap.library.map.sub.Cs2dBackground;
import net.ddns.endercypt.cs2dmap.library.map.sub.Cs2dEntities;
import net.ddns.endercypt.cs2dmap.library.map.sub.Cs2dMapArray;
import net.ddns.endercypt.cs2dmap.library.map.sub.Cs2dTiles;
import net.ddns.endercypt.cs2dmap.library.map.sub.extra.map.MapSection;
import net.ddns.endercypt.cs2dmap.library.map.sub.extra.tile.TileMode;
import net.ddns.endercypt.cs2dmap.library.map.sub.extra.tile.action.TileActions;

public class CreateMap
{
	public static void main(String[] args) throws IOException
	{
		try
		{
			// new map
			Cs2dMap cs2dMap = new Cs2dMap();

			// configure background
			Cs2dBackground background = cs2dMap.getBackground();
			background.setFilename("toxic.jpg");
			cs2dMap.update(background);

			// tile
			Cs2dTiles tiles = cs2dMap.getTiles();
			tiles.tileModes().set(1, TileMode.WALL);
			tiles.tileHeights().set(1, 32 * 5);
			cs2dMap.update(tiles);

			// map
			Cs2dMapArray map = cs2dMap.getMapArray();
			map.resizeMap(10, 10);
			map.fill(TileActions.setFrame(1));
			map.rectangle(1, 1, 8, 8, TileActions.setFrame(9));
			map.circle(1, 1, 8, 8, TileActions.setFrame(34));
			map.tile(2, 9).setFrame(5);
			map.tile(5, 8).setTileModifier(new ColorTileModifier(255, 0, 0, 1));

			MapSection copy = map.copy(0, 0, 5, 5);
			copy.pasteInto(map, -1, -1);

			map.shift(1, 1, TileActions.setFrame(39));

			cs2dMap.update(map);

			// entities
			Cs2dEntities cs2dEntities = cs2dMap.getEntities();

			//new Info_CTF_Flag().setFlagTeam(Team);
			//new Info_TeamGate().setAllowedTeam(Info_TeamGate.Team.NOBODY);

			// t spawn
			Info_T info_T = new Info_T();
			info_T.setLocation(5, 1);
			cs2dEntities.addEntity(info_T);

			// ct spawn
			Info_CT info_CT = new Info_CT();
			info_CT.setLocation(5, 8);
			cs2dEntities.addEntity(info_CT);

			// hostages
			Info_Hostage info_Hostage = new Info_Hostage();
			info_Hostage.setLocation(5, 5);
			info_Hostage.setLook(HostageLooks.BALD_SCIENTIST);
			cs2dEntities.addEntity(info_Hostage);

			cs2dMap.update(cs2dEntities);

			// save
			Cs2dMapWriter.write(cs2dMap, new File("maps/test.map"));

			// copy
			Files.copy(Paths.get("maps/test.map"), Paths.get("/Users/EnderCrypt/Library/Application Support/Steam/steamapps/common/CS2D/maps/test.map"), StandardCopyOption.REPLACE_EXISTING);
		}
		catch (Cs2dUnexpectedEOFException e)
		{
			System.err.println(e.getMessage());
			e.saveDebugByteString(new File("dump.txt"));
		}
		System.out.println("Done!");
	}
}
