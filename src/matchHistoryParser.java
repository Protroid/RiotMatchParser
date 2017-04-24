package matchHistoryParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.match.Match;
import com.robrua.orianna.type.core.match.Participant;
import com.robrua.orianna.type.dto.match.MatchDetail;
import com.robrua.orianna.type.dto.match.Team;

public class matchHistoryParser 
{
	public static void main (String [] args) 
	{
		long matchID = 2462671469l; //Enter a match ID as a long
		String filePat = "<Enter your file path>";
		MatchDetail matchDetails;
		Match myMatch;
		Boolean blueWins = false;
		long matchTime;
		List<Team> matchTeams;
		List<Participant> matchPlayers;
		com.robrua.orianna.type.dto.match.Participant currentPlayer;
		String championName = "";
		championDictionary DICT = new championDictionary();
		Map<Long,String> champDict = DICT.getDictionary();
		Map<String, championData> existingChamps = new HashMap<>();
		
		System.out.println("My ID: "+matchID);
		Scanner currentLine = null;
		try 
		{
			currentLine = new Scanner(new FileInputStream(filePat));
		} 
		catch (FileNotFoundException e) 
		{
		}
		
		if(currentLine != null)
		{
			while (currentLine.hasNextLine())
			{ 
				String[] values = null;
				values = currentLine.nextLine().split(",");
				
				existingChamps.put(values[0], new championData(values[0], Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), Double.parseDouble(values[6]), Double.parseDouble(values[7]), Double.parseDouble(values[8]), Double.parseDouble(values[9]), Double.parseDouble(values[10]), Double.parseDouble(values[11]), Double.parseDouble(values[12]), Double.parseDouble(values[13]), Double.parseDouble(values[14]), Double.parseDouble(values[15]), Double.parseDouble(values[16]), Double.parseDouble(values[17]), Double.parseDouble(values[18]), Double.parseDouble(values[19]), Double.parseDouble(values[20])));
			} 
		}
		
		RiotAPI.setAPIKey("<Enter your API Key>");
		RiotAPI.setRegion(Region.NA);
        myMatch = RiotAPI.getMatch(matchID);
        matchDetails = myMatch.getDto();
        matchPlayers = myMatch.getParticipants();
        matchTeams = matchDetails.getTeams();
        
        System.out.println("Starting...");
        
        //First, lets determine who won
        if (matchTeams.get(0).getWinner())
        	blueWins = true;
        
        //Now, lets find out how long the match was (in seconds)
        matchTime = matchDetails.getMatchDuration();
        
        //Next, lets update the banned champions
        for(int team = 0; team < 2; team++)
        {
        	for(int slot = 0; slot < matchTeams.get(team).getBans().size(); slot++)
        	{
        		championName = champDict.get((long)(matchTeams.get(team).getBans().get(slot).getChampionId()));
        		if(existingChamps.get(championName) != null)
        			existingChamps.get(championName).incBans();
        		else
        		{
        			existingChamps.put(championName, new championData(championName));
        			existingChamps.get(championName).incBans();
        		}

        	}
        }
        
        System.out.println("Updating statistics...");
        
        //Now, we can update the stats of specific champions, or create new entries if none existed previously
        for(int i = 0; i < matchPlayers.size(); i++)
        {
        	currentPlayer = matchPlayers.get(i).getDto().getParticipant();
        	championName = champDict.get((long)currentPlayer.getChampionId());
        	if(existingChamps.get(championName) != null)
        	{
        		//Number of Games
        		existingChamps.get(championName).incGames();
        		//Win Loss Ratio
        		if((currentPlayer.getTeamId() == 100 && blueWins) || currentPlayer.getTeamId() == 200 && !blueWins)
        			existingChamps.get(championName).incWins();
        		else
        			existingChamps.get(championName).incLosses();
        		//Kills
        		existingChamps.get(championName).addKills(currentPlayer.getStats().getKills());
        		//Deaths
        		existingChamps.get(championName).addDeaths(currentPlayer.getStats().getDeaths());
        		//Assists
        		existingChamps.get(championName).addAssists(currentPlayer.getStats().getAssists());
        		//Firstblood
        		if(currentPlayer.getStats().getFirstBloodKill())
        			existingChamps.get(championName).incFirstBloods();
        		//Total Killing Spree
        		existingChamps.get(championName).addKillingSpree(currentPlayer.getStats().getKillingSprees());
        		//Damage Dealt (to Champs)
        		existingChamps.get(championName).addDamageDealt(currentPlayer.getStats().getTotalDamageDealtToChampions());
        		//Largest Crit
        		existingChamps.get(championName).addLargestCrit(currentPlayer.getStats().getLargestCriticalStrike());
        		//Damage Taken
        		existingChamps.get(championName).addDamageTaken(currentPlayer.getStats().getTotalDamageTaken());
        		//Damage Healed
        		existingChamps.get(championName).addDamageHealed(currentPlayer.getStats().getTotalHeal());
        		//Wards Placed
        		existingChamps.get(championName).addWardsPlaced(currentPlayer.getStats().getWardsPlaced());
        		//Wards Destroyed
        		existingChamps.get(championName).addWardsDestroyed(currentPlayer.getStats().getWardsKilled());
        		//Gold Earned
        		existingChamps.get(championName).addGoldEarned(currentPlayer.getStats().getGoldEarned());
        		//CS
        		existingChamps.get(championName).addCS(currentPlayer.getStats().getMinionsKilled());
        		//Neutral Minions (Jungle) Killed
        		existingChamps.get(championName).addNeutralMinionsKilled(currentPlayer.getStats().getNeutralMinionsKilled());
        		//Neutral Minions (Counter Jungle) Killed
        		existingChamps.get(championName).addNeutralMinionsKilled(currentPlayer.getStats().getNeutralMinionsKilledEnemyJungle());
        		//Time
        		existingChamps.get(championName).addTime(matchTime);
        	}
        	else
        	{
        		//Create new Champion Entry
        		existingChamps.put(championName, new championData(championName, 1, 0, 0, 0, currentPlayer.getStats().getKills(), currentPlayer.getStats().getDeaths(), currentPlayer.getStats().getAssists(), 0, currentPlayer.getStats().getKillingSprees(), currentPlayer.getStats().getTotalDamageDealtToChampions(), currentPlayer.getStats().getTotalDamageTaken(), currentPlayer.getStats().getTotalHeal(), currentPlayer.getStats().getLargestCriticalStrike(), currentPlayer.getStats().getWardsPlaced(), currentPlayer.getStats().getWardsKilled(), currentPlayer.getStats().getGoldEarned(), currentPlayer.getStats().getMinionsKilled(), currentPlayer.getStats().getNeutralMinionsKilled(), currentPlayer.getStats().getNeutralMinionsKilledEnemyJungle(), matchTime));
        		//Record if the new entry won or lost
        		if((currentPlayer.getTeamId() == 100 && blueWins) || currentPlayer.getTeamId() == 200 && !blueWins)
        			existingChamps.get(championName).incWins();
        		else
        			existingChamps.get(championName).incLosses();
        		//Record if the entry got first blood
        		if(currentPlayer.getStats().getFirstBloodKill())
        			existingChamps.get(championName).incFirstBloods();
        	}
        	
        }
        
        System.out.println("Pushing update to file...");
        
        //Finally, we have to update our file!
        File file = new File(filePat);
        try
		{
		    PrintWriter writer = new PrintWriter(file, "UTF-8");
		    for (Map.Entry<String, championData> entry : existingChamps.entrySet())
		    {
		        writer.println(entry.getValue().toString());
		    }

			writer.close();
		} 
		catch (Exception e) {} 
        
        System.out.println("Done!");
	}
}
