import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
//
// function Welcome(props) {
//     return <h1>Hello, {props.name}, {props.name2}</h1>;
// }
//
// const element = <Welcome name="Sara" name2="Misha"/>;
// ReactDOM.render(
//     element,
//     document.getElementById('root')
// );
// ReactDOM.render(
//     <App/>,
//     document.getElementById('root')
// );


// const INTERVAL = 100;
//
// class Timer extends React.Component {
//     constructor(props) {
//         super(props);
//         this.state = {value: 0};
//     }
//
//     increment(){
//         this.setState({value: this.state.value + 1});
//     }
//
//     componentDidMount() {
//         this.timerID = setInterval(() => this.increment(), 1000/INTERVAL);
//     }
//
//     componentWillUnmount() {
//         clearInterval(this.timerID);
//     }
//
//     render() {
//         const value = this.state.value
//         return (
//             <div>
//                 <p>Таймер:</p>
//                 <p>
//                     <span>{Math.round(value/INTERVAL/60/60)} : </span>
//                     <span>{Math.round(value/INTERVAL/60)} : </span>
//                     <span>{Math.round(value/INTERVAL)} . </span>
//                     <span>{value % INTERVAL}</span>
//                 </p>
//             </div>
//         );
//     }
// }
// function Application() {
//     return (
//         <p>
//             <Timer/>
//             <Timer/>
//             <Timer/>
//         </p>
//     );
// }
//
// ReactDOM.render(<Application/>, document.getElementById('root'));

function SetFireButton(props) {
    return (<button className="orange" onClick={props.onClick}>Зажечь</button>);
}

function SnuffOutButton(props) {
    return (<button className="blue" onClick={props.onClick}>Потушить</button>);
}

class FirePlace extends React.Component {
    constructor(props) {
        super(props);
        this.onSetFire = this.onSetFire.bind(this);
        this.onSnuffOut = this.onSnuffOut.bind(this);
        this.state = {isBurning: false};
    }

    onSetFire() {
        this.setState({isBurning: true});
    }

    onSnuffOut() {
        this.setState({isBurning: false});
    }

    render() {
        const isBurning = this.state.isBurning;

        let button = null;
        if(isBurning){
            button = <SnuffOutButton onClick={this.onSnuffOut} />
        } else {
            button = <SetFireButton onClick={this.onSetFire} />;
        }
        return (
            <div>
                <Indicator isBurning={isBurning} />
                {button}
            </div>
        );
    }
}

ReactDOM.render(<FirePlace/>, document.getElementById('root'));