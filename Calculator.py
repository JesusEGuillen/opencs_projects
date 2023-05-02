import tkinter as tk

class Calculator:
    def __init__(self, master):
        # Create the Calculator class to create the calculator interface.
        self.master = master

        # Set the title of the master window to "Calculator"
        self.master.title("Calculator")

        self.result_var = tk.StringVar()
        self.result_var.set("0")

        # Create the Entry widget to display the user's input.
        self.entry = tk.Entry(self.master, textvariable=self.result_var)
        self.entry.grid(row=0, column=0, columnspan=4, sticky="news")

        # Create each button for the calculator interface.
        # Each button calls the button_click() method when clicked.
        # The button_click() method updates the input in the Entry widget.
        self.create_button("1", 1, 0)
        self.create_button("2", 1, 1)
        self.create_button("3", 1, 2)
        self.create_button("+", 1, 3)

        self.create_button("4", 2, 0)
        self.create_button("5", 2, 1)
        self.create_button("6", 2, 2)
        self.create_button("-", 2, 3)

        self.create_button("7", 3, 0)
        self.create_button("8", 3, 1)
        self.create_button("9", 3, 2)
        self.create_button("*", 3, 3)

        self.create_button("0", 4, 0)
        self.create_button("C", 4, 1)
        self.create_button("=", 4, 2)
        self.create_button("/", 4, 3)

    def create_button(self, text, row, column):
        # Create a button with the given text, row, and column.
        # The button calls the button_click() method when clicked.
        # The button has a height of 3 and width of 8 to make it bigger.
        button = tk.Button(self.master, text=text, height=3, width=8, command=lambda: self.button_click(text))
        button.grid(row=row, column=column, sticky="news")

    def button_click(self, text):
        # Update the Entry widget based on the button clicked.
        # If the "C" button is clicked, clear the input.
        # If the "=" button is clicked, evaluate the input and display the result.
        # If a number or operator button is clicked, add it to the input.
        if text == "C":
            self.result_var.set("0")
        elif text == "=":
            self.result_var.set(str(eval(self.result_var.get())))
        else:
            if self.result_var.get() == "0":
                self.result_var.set(text)
            else:
                self.result_var.set(self.result_var.get() + text)

root = tk.Tk()
app = Calculator(root)
root.mainloop()
