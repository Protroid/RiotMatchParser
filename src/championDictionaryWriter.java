package matchHistoryParser;

import java.util.List;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.staticdata.Champion;

public class championDictionaryWriter 
{
	public static void main (String [] args) 
	{
		List<Champion> allChamps;
		
		RiotAPI.setAPIKey("<Enter your API Key>");
		RiotAPI.setRegion(Region.NA);
		
		allChamps = RiotAPI.getChampions();
		
		championDictionary DICT = new championDictionary(allChamps);
		
		DICT.writeToDictionary();
		
	}
}
