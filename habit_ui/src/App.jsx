import './App.css';
import TodaysDate from './components/date';
import HabitProgressBar from './components/progressbar';
import Header from './layout/header.jsx';

const App = () => {
  const habitData = [
    [true, true, false, true, true, true, true, false, false, true], // HABIT 1
    [true, false, true, false, true, true, false], // HABIT 2
    [false, true, false, false, false, true, true], // HABIT 3
    [true, true, true],
    [false, true, false, false, false, true, true]
  ];

  return (
    <div className="App">
      <header className="App-header">
        <Header />
      </header>
      <main className='App-content'>
        <TodaysDate />
        <HabitProgressBar habitData={habitData} />
      </main>
    </div>
  );
};

export default App;
