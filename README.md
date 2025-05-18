# gameRPS

# 🎮 Rock Paper Scissors Lizard Spock - Java Game



Konsolowa gra napisana w Javie z wykorzystaniem zasad programowania obiektowego i popularnych wzorców projektowych. Projekt pozwala zagrać w klasyczne "papier, kamień, nożyce" oraz rozszerzony wariant "Lizard-Spock", zarówno przeciwko komputerowi, jak i w trybie CPU vs CPU.

---

## 📦 Zawartość projektu

- `Game` – model gry (gracze, rundy, symbole)
- `GamePlay` – logika przebiegu gry (menu, rozgrywka, wynik)
- `GameFactory` – tworzenie gry (z uwzględnieniem trybów)
- `GameBuilder` – wzorzec Builder do wygodnego tworzenia gry
- `CpuPlayer`, `User` – gracz komputerowy i użytkownik
- `Symbol` – abstrakcja ruchu + konkretne symbole (`Rock`, `Paper`, `Scissors`, `Lizard`, `Spock`)
- `CpuStrategy` – interfejs strategii dla CPU + kilka implementacji
- `Menu` – główne menu gry

---

## ✅ Funkcje

- 🔁 **Wielokrotny wybór trybu gry** z poziomu menu
- 🧠 **Poziomy trudności**: (ToDo)
    - `easy`: CPU ma większą szansę na wygraną
    - `hard`: pełna losowość
- 🎲 **Tryby symboli**:
    - `normal`: Rock, Paper, Scissors
    - `extended`: + Lizard i Spock
- 🤖 **Tryb demo**: CPU vs CPU (np. do testów AI)
- 🧩 **Wzorce projektowe**:
    - `Factory` – GameFactory do tworzenia obiektów
    - `Builder` – GameBuilder do konfigurowalnego tworzenia gry
    - `Strategy` – CpuStrategy (np. `RandomStrategy`, `AlwaysRockStrategy`, `WeightedStrategy`)
    - `Decorator` *(planowany)* – rozszerzanie graczy np. o statystyki, czas reakcji
    - `State` *(opcjonalny)* – stany gry (menu, rozgrywka, koniec)

---

## 🛠️ Uruchamianie

1. Skompiluj projekt:
   ```bash
   javac -d out src/**/*.java
