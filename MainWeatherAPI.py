import requests
import json
import tkinter as tk
from tkinter import ttk

api_key = "0feb86b321c3d721ffef88cee4acf9e5"
base_url = "http://api.openweathermap.org/data/2.5/weather?"

# Function to get weather information
def get_weather():
    city_name = city_entry.get()
    complete_url = base_url + "appid=" + api_key + "&q=" + city_name
    response = requests.get(complete_url)
    x = response.json()

    if x["cod"] != "404":
        y = x["main"]
        current_temperature = int((y["temp"] - 273.15) * 1.8 + 32)
        current_pressure = y["pressure"]
        current_humidity = y["humidity"]
        current_max = int((y["temp_max"] - 273.15) * 1.8 + 32)
        current_low = int((y["temp_min"] - 273.15) * 1.8 + 32)
        z = x["weather"]
        weather_description = z[0]["description"]

        # Clear the weather label
        weather_label.config(text="")

        # Display the weather information
        weather_label.config(text="\n The weather in " + str(city_name) + " looks like" +
                                    "\n Temperature (in Fahrenheit unit): " + str(current_temperature) +
                                    "\n High in temperature today (Fahrenheit): " + str(current_max) +
                                    "\n Low in temperature today (Fahrenheit): " + str(current_low) +
                                    "\n Humidity (in percentage): " + str(current_humidity) + "%" +
                                    "\n Today in " + str(city_name) + " looks like: " + str(weather_description) + "\n")
    else:
        # Clear the weather label and display error message
        weather_label.config(text="")
        weather_label.config(text="City Not Found")

# Create a window
window = tk.Tk()
window.title("Weather App")
window.geometry("750x500")

# Create a style object
style = ttk.Style()
style.theme_use('default')
style.configure("TLabel", font=("Helvetica", 34), padding=10)
style.configure("TEntry", font=("Helvetica", 34))

# Create a label for the city entry
city_label = ttk.Label(window, text="Enter city name: ")
city_label.pack()

# Create an entry for the city name
city_entry = ttk.Entry(window)
city_entry.pack()

# Create a button to get the weather information
get_weather_button = ttk.Button(window, text="Get Weather", command=get_weather)
get_weather_button.pack()

# Create a label for the weather information
weather_label = ttk.Label(window)
weather_label.pack()

# Run the window
window.mainloop()
