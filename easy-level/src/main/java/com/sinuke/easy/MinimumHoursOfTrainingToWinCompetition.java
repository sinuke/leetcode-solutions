package com.sinuke.easy;

public class MinimumHoursOfTrainingToWinCompetition {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int totalEnergy = 0;
        for (int en : energy) totalEnergy += en;

        int training = initialEnergy <= totalEnergy ? totalEnergy - initialEnergy + 1 : 0;
        int exp = initialExperience;
        for (int ex : experience) {
            if (ex < exp) exp += ex;
            else {
                int t = ex - exp + 1;
                training += t;
                exp += t + ex;
            }
        }

        return training;
    }

}
