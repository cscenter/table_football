import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';

function Welcome(props) {
    return <h1>Hello, {props.name}, {props.name2}</h1>;
}

const element = <Welcome name="Sara" name2="Misha"/>;
ReactDOM.render(
    element,
    document.getElementById('root')
);
ReactDOM.render(
    <App/>,
    document.getElementById('root')
);


const INTERVAL = 100;

class Timer extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: 0};
    }

    increment(){
        this.setState({value: this.state.value + 1});
    }

    componentDidMount() {
        this.timerID = setInterval(() => this.increment(), 1000/INTERVAL);
    }

    componentWillUnmount() {
        clearInterval(this.timerID);
    }

    render() {
        const value = this.state.value
        return (
            <div>
                <p>Таймер:</p>
                <p>
                    <span>{Math.round(value/INTERVAL/60/60)} : </span>
                    <span>{Math.round(value/INTERVAL/60)} : </span>
                    <span>{Math.round(value/INTERVAL)} . </span>
                    <span>{value % INTERVAL}</span>
                </p>
            </div>
        );
    }
}
function TimerExample() {
    return (
        <p>
            <Timer/>
            <Timer/>
            <Timer/>
        </p>
    );
}

export default TimerExample;