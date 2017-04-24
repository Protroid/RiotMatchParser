package matchHistoryParser;

public class championData 
{
	String championName = "";
	double championGames = 0;
	double championWins = 0;
	double championLosses = 0;
	double championBans = 0;
	double championKills = 0;
	double championAssists = 0;
	double championDeaths = 0;
	double championFirstBloods = 0;
	double championTotalKillingSpree = 0;
	double championTotalDamageDealt = 0;
	double championLargestCrit = 0;
	double championDamageTaken = 0;
	double championDamageHealed = 0;
	double championWardsPlaced = 0;
	double championWardsDestroyed = 0;
	double championGoldEarned = 0;
	double championMinionsKilled = 0;
	double championNeutralMinionsKilled = 0;
	double championCounterJungleMinionsKilled = 0;
	double championMatchTime = 0;
	
	public championData(String name)
	{
		championName = name;
	}
	
	public championData(String name, double games, double wins, double losses, double bans, double kills, double deaths, double assists, double firstBloods, double killingSprees, double damageDealt, double damageTaken, double damageHealed, double largestCrit, double wardsPlaced, double wardsCleared, double goldEarned, double cs, double jungleMinions, double enemyJungleMinions, double time)
	{
		championName = name;
		championGames = games;
		championWins = wins;
		championLosses = losses;
		championBans = bans;
		championKills = kills;
		championAssists = assists;
		championDeaths = deaths;
		championFirstBloods = firstBloods;
		championTotalKillingSpree = killingSprees;
		championTotalDamageDealt = damageDealt;
		championLargestCrit = largestCrit;
		championDamageTaken = damageTaken;
		championDamageHealed = damageHealed;
		championWardsPlaced = wardsPlaced;
		championWardsDestroyed = wardsCleared;
		championGoldEarned = goldEarned;
		championMinionsKilled = cs;
		championNeutralMinionsKilled = jungleMinions;
		championCounterJungleMinionsKilled = enemyJungleMinions;
		championMatchTime = time;
	}
	public void setName(String name)
	{
		championName = name;
	}
	
	public String getName()
	{
		return championName;
	}
	
	public void setGames(double game)
	{
		championGames = game;
	}
	
	public void incGames()
	{
		championGames++;
	}
	
	public double getGames()
	{
		return championGames;
	}
	
	public void setWins(double win)
	{
		championWins = win;
	}
	
	public void incWins()
	{
		championWins++;
	}
	
	public double getWins()
	{
		return championWins;
	}
	
	public void setLosses(double loss)
	{
		championLosses = loss;
	}
	
	public void incLosses()
	{
		championLosses++;
	}
	
	public double getLosses()
	{
		return championLosses;
	}
	
	public void setBans(double ban)
	{
		championBans = ban;
	}
	
	public void incBans()
	{
		championBans++;
	}
	
	public double getBans()
	{
		return championBans;
	}
	
	public void setKills(double kill)
	{
		championKills = kill;
	}
	
	public void addKills(double kill)
	{
		championKills += kill;
	}
	
	public double getKills()
	{
		return championKills;
	}
	
	public void setAssists(double assists)
	{
		championAssists = assists;
	}
	
	public void addAssists(double assists)
	{
		championAssists+= assists;
	}
	
	public double getAssists()
	{
		return championAssists;
	}
	
	public void setDeaths(double death)
	{
		championDeaths = death;
	}
	
	public void addDeaths(double death)
	{
		championDeaths+= death;
	}
	
	public double getDeaths()
	{
		return championDeaths;
	}
	
	public void setFirstBloods(double fb)
	{
		championFirstBloods = fb;
	}
	
	public void incFirstBloods()
	{
		championFirstBloods++;
	}
	
	public double getFirstBloods()
	{
		return championFirstBloods;
	}
	
	public void setKillingSpree(double ks)
	{
		championTotalKillingSpree = ks;
	}
	
	public void addKillingSpree(double ks)
	{
		championTotalKillingSpree += ks;
	}
	
	public double getKillingSpree()
	{
		return championTotalKillingSpree;
	}
	
	public void setDamageDealt(double dd)
	{
		championTotalDamageDealt = dd;
	}
	
	public void addDamageDealt(double dd)
	{
		championTotalDamageDealt+= dd;
	}
	
	public double getDamageDealt()
	{
		return championTotalDamageDealt;
	}
	
	public void setlargestCrit(double lc)
	{
		championLargestCrit = lc;
	}
	
	public void addLargestCrit(double lc)
	{
		if(lc > championLargestCrit)
			championLargestCrit = lc;
	}
	
	public double getlargestCrit()
	{
		return championLargestCrit;
	}
	
	public void setDamageTaken(double dt)
	{
		championDamageTaken = dt;
	}
	
	public void addDamageTaken(double dt)
	{
		championDamageTaken+= dt;
	}
	
	public double getDamageTaken()
	{
		return championDamageTaken;
	}
	
	public void setDamageHealed(double dh)
	{
		championDamageHealed = dh;
	}
	
	public void addDamageHealed(double dh)
	{
		championDamageHealed+= dh;
	}
	
	public double getDamageHealed()
	{
		return championDamageHealed;
	}
	
	public void setWardsPlaced(double wp)
	{
		championWardsPlaced = wp;
	}
	
	public void addWardsPlaced(double wp)
	{
		championWardsPlaced+= wp;
	}
	
	public double getWardsPlaced()
	{
		return championWardsPlaced;
	}
	
	public void setWardsDestroyed(double wd)
	{
		championWardsDestroyed = wd;
	}
	
	public void addWardsDestroyed(double wd)
	{
		championWardsDestroyed+= wd;
	}
	
	public double getWardsDestroyed()
	{
		return championWardsDestroyed;
	}
	
	public void setGoldEarned(double ge)
	{
		championGoldEarned = ge;
	}
	
	public void addGoldEarned(double ge)
	{
		championGoldEarned+= ge;
	}
	
	public double getGoldEarned()
	{
		return championGoldEarned;
	}
	
	public void setCS(double cs)
	{
		championMinionsKilled = cs;
	}
	
	public void addCS(double cs)
	{
		championMinionsKilled+= cs;
	}
	
	public double getCS()
	{
		return championMinionsKilled;
	}
	
	public void setNeutralMinionsKilled(double nm)
	{
		championNeutralMinionsKilled = nm;
	}
	
	public void addNeutralMinionsKilled(double nm)
	{
		championNeutralMinionsKilled+= nm;
	}
	
	public double getNeutralMinionsKilled()
	{
		return championNeutralMinionsKilled;
	}
	
	public void setCounterJungleMinionsKilled(double cj)
	{
		championCounterJungleMinionsKilled = cj;
	}
	
	public void addCounterJungleMinionsKilled(double cj)
	{
		championCounterJungleMinionsKilled += cj;
	}
	
	public double getCounterJungleMinionsKilled()
	{
		return championCounterJungleMinionsKilled;
	}
	
	public void setTime(double time)
	{
		championMatchTime = time;
	}
	
	public void addTime(double time)
	{
		championMatchTime += time;
	}
	
	public double getTime()
	{
		return championMatchTime;
	}
	
	public String toString()
	{
		return championName+", "+championGames+", "+championWins+", "+championLosses+", "+championBans+", "+championKills+", "+championDeaths+", "+championAssists+", "+championFirstBloods+", "+championTotalKillingSpree+", "+championTotalDamageDealt+", "+championDamageTaken+", "+championDamageHealed+", "+championLargestCrit+", "+championWardsPlaced+", "+championWardsDestroyed+", "+championGoldEarned+", "+championMinionsKilled+", "+championNeutralMinionsKilled+", "+championCounterJungleMinionsKilled+", "+championMatchTime;
	}
	
	
}