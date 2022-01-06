package com.initial.start.bookmyshow.utils;

 enum ShowTimes {

     S1("10:30AM"),
     S2("11:00AM"),
     S3("12::00PM"),
     S4("2:00PM"),
     S5("6:00PM"),
     S6("8:30PM");

        private String timings;
        ShowTimes(String timings)
        {
            this.timings = timings;
        }

        public String getTimings()
        {
            return timings;
        }


}
