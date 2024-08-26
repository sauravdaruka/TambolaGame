# Tambola Game

## Assumptions
- The ticket is represented as a 3x5 grid.
- Claims are validated based on the announced numbers.

## Setup
1. Add the necessary dependencies for build tool.
2. Instantiate `TambolaManager` and set up the ticket using `setTicket()`.

## Usage
1. Initialize the ticket:
   ```java
   TambolaManager manager = TambolaManager.getTambolaManager();
   manager.setTicket(new Ticket(numbers));

2. ClaimStatus status = manager.validateClaim(ClaimType.TOP_LINE, announcedNumbers);

