import React from "react";
import axios from 'axios/index'

function SnuffOutButton(props) {
    return (<button className="blue" onClick={props.onClick}>{props.text}</button>);
}

function SetFireButton(props) {
    return (<button className="orange" onClick={props.onClick}>{props.text}</button>);
}

class FirePlace extends React.Component {
    constructor(props) {
        super(props);
        this.onSetFire = this.onSetFire.bind(this);
        this.onSnuffOut = this.onSnuffOut.bind(this);
        this.state = {isBurning: true};
    }

    onSetFire() {
        this.setState({isBurning: true});
    }

    onSnuffOut() {
        this.setState({isBurning: false});
    }

    componentDidMount() {
        axios.get(`http://0.0.0.0:8080/snippets`)
            .then(response => response.data)
            .then(data => this.setState({ user: data.user }))
    }
    render() {
        const isBurning = this.state.isBurning;

        let button = null;
        if(isBurning){
            button = <SnuffOutButton onClick={this.onSnuffOut}  text={this.state.user}/>
        } else {
            button = <SetFireButton onClick={this.onSetFire} text="fvhvvj" />;
        }
        return (
            <div>
                {button}
                {button}
                {button}
                {button}
            </div>
        );
    }
}

export default FirePlace;