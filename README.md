# Cinema Booking System

A console-based cinema seat booking application written in Java that allows users to view available seats, purchase tickets, and track booking statistics.

## Features

- **Interactive Seat Display**: Visual representation of cinema seating arrangement
- **Ticket Booking**: Reserve seats with real-time availability checking
- **Dynamic Pricing**: Different pricing tiers based on cinema size and seat location
- **Statistics Tracking**: Monitor sales performance and occupancy rates
- **Input Validation**: Robust error handling for user inputs

## How It Works

### Pricing Structure

The system implements a tiered pricing model:

- **Small Cinema** (≤60 seats): All seats cost $10
- **Large Cinema** (>60 seats):
    - Front half rows: $10 (Premium seats)
    - Back half rows: $8 (Regular seats)

### Seat Representation

- `S` - Available seat
- `B` - Booked seat
- Numbers along edges represent row and column indices

## Usage

### Initial Setup

1. **Enter Cinema Dimensions**:
    - Number of rows (1-9)
    - Number of seats per row (1-9)

### Main Menu Options

1. **Show the seats** - Display current seating arrangement
2. **Buy a ticket** - Purchase a seat reservation
3. **Statistics** - View booking analytics
4. **Exit** - Close the application

### Booking Process

1. Select option 2 from the main menu
2. Enter desired row number
3. Enter desired seat number
4. System validates availability and displays ticket price
5. Seat is marked as booked upon successful purchase

### Statistics Overview

The statistics feature provides:
- Total number of purchased tickets
- Percentage of seats booked
- Current income generated
- Maximum potential income

## Code Structure

### Key Components

- **Main Method**: Handles user interface and menu navigation
- **Seat Management**:
    - `fillSeatMatrix()` - Initializes seating chart
    - `displaySeats()` - Shows current seat status
    - `updateSeatMatrixAfterSeatSelection()` - Marks seats as booked
- **Booking Logic**:
    - `buyTicket()` - Processes seat reservations
    - `computeTicketPrice()` - Calculates pricing based on location
    - `isValidSeats()` - Validates user input
- **Analytics**:
    - `updateStatistics()` - Tracks booking metrics
    - `showStatistics()` - Displays performance data
    - `computeTotalIncome()` - Calculates maximum revenue potential

### Constants

- `MAX_ROW/MAX_COL`: Maximum cinema dimensions (9x9)
- `MIN_ROW/MIN_COL`: Minimum cinema dimensions (1x1)
- `SMALL_CINEMA_THRESHOLD`: Seat count threshold for pricing (60)
- `PREMIUM_SEAT_PRICE`: Front row ticket price ($10)
- `REGULAR_SEAT_PRICE`: Back row ticket price ($8)

## Limitations

- Maximum cinema size: 9 rows × 9 columns
- Console-based interface only
- No data persistence between sessions
- Single-user operation

## Example Usage

```
Enter the number of rows
5
Enter the number of seats in each row:
6

1. Show the seats
2. Buy a ticket  
3. Statistics
0. Exit
1

Cinema:
  1 2 3 4 5 6 
1 S S S S S S 
2 S S S S S S 
3 S S S S S S 
4 S S S S S S 
5 S S S S S S 

1. Show the seats
2. Buy a ticket
3. Statistics  
0. Exit
2

Enter a row number:
2
Enter a seat number in that row:
3
Ticket price: $10
```

## Contributing

Feel free to suggest improvement in code!!
