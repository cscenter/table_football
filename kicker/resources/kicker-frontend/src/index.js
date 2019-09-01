import React from "react";
import ReactDOM from 'react-dom';
import FirePlace from './examples/FireplaceExample';
import RouterExample from "./examples/RouterExample";
import TimerExample from "./examples/TimerExample";
import GameCell from "./GameCell";
import GamesTable from "./GamesTable";
import SimpleTable from "./Table";
import GamesPage from "./GamesPage";


// ReactDOM.render(<RouterExample/>, document.getElementById('root'));
// ReactDOM.render(<TimerExample/>, document.getElementById('root'));
// ReactDOM.render(<FirePlace/>, document.getElementById('root'));
// ReactDOM.render(<GameCell/>, document.getElementById('root'));
// ReactDOM.render(<GamesTable/>, document.getElementById('root'));
// ReactDOM.render(<SimpleTable/>, document.getElementById('root'));
ReactDOM.render(<GamesPage/>, document.getElementById('root'));