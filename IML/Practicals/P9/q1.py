# Write a Pandas program to create a plot of Open, High, Low, Close,
# Adjusted Closing prices and Volume of given company between two
# specific dates.

import pandas as pd
import matplotlib.pyplot as plt


def plot_stock_data(company, start_date, end_date):

    # Plot stock prices and volume for a company between two dates
    # Parameters:
    # company: 'AAPL', 'MSFT', 'GOOG', or 'NFLX'
    # start_date: '2023-02-07' (format: YYYY-MM-DD)
    # end_date: '2023-05-05' (format: YYYY-MM-DD)

    df = pd.read_csv("stocks.csv")
    df["Date"] = pd.to_datetime(df["Date"])

    filtered_data = df[
        (df["Ticker"] == company)
        & (df["Date"] >= start_date)
        & (df["Date"] <= end_date)
    ]

    if filtered_data.empty:
        print(f"No data found for {company} between {start_date} and {end_date}")
        return

    fig, (ax1, ax2) = plt.subplots(2, 1, figsize=(12, 10))
    
    # Plot 1: Stock Prices
    ax1.plot(filtered_data["Date"], filtered_data["Open"], label="Open", linewidth=2)
    ax1.plot(filtered_data["Date"], filtered_data["High"], label="High", linewidth=2)
    ax1.plot(filtered_data["Date"], filtered_data["Low"], label="Low", linewidth=2)
    ax1.plot(filtered_data["Date"], filtered_data["Close"], label="Close", linewidth=3)
    ax1.plot(
        filtered_data["Date"],
        filtered_data["Adj Close"],
        label="Adj Close",
        linewidth=2,
        linestyle="--",
    )

    ax1.set_title(f"{company} Stock Prices ({start_date} to {end_date})", fontsize=16)
    ax1.set_ylabel("Price ($)", fontsize=12)
    ax1.legend()
    ax1.grid(True)

    # Plot 2: Volume
    ax2.bar(filtered_data["Date"], filtered_data["Volume"], color="orange", alpha=0.7)
    ax2.set_title(f"{company} Trading Volume", fontsize=14)
    ax2.set_ylabel("Volume", fontsize=12)
    ax2.set_xlabel("Date", fontsize=12)
    ax2.grid(True)

    plt.show()


plot_stock_data("AAPL", "2023-03-01", "2023-03-31")

# Uncomment the following lines to test with different companies and date ranges

# plot_stock_data("MSFT", "2023-04-01", "2023-04-30")

# plot_stock_data("GOOG", "2023-02-15", "2023-04-15")

# plot_stock_data("NFLX", "2023-02-01", "2023-02-28")
