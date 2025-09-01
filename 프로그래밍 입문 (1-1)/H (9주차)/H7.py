def get_day_of_the_week(s : str) -> str :
    dotw = {"Sun" : "Sunday",
            "Mon" : "Monday",
            "Tue" : "Tuesday",
            "Wed" : "Wednesday",
            "Thu" : "Thursday",
            "Fri" : "Friday",
            "Sat" : "Saturday"}
    
    try :
        return dotw[s]
    except:
        return 'X'

a = input()
print(get_day_of_the_week(a))