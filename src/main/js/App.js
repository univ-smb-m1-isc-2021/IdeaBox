import React, {Component} from "react";
import Panel from "./components/Panel";
import BoardWrapper from "./components/BoardWrapper";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            result: []
        }

    }

    componentWillMount() {
        fetch("/react/users")
            .then(response => response.json())
            .then((data) => {
                this.setState({result: data})
            });
    }

    render() {
        return (
            <BoardWrapper>
                {this.state.result.map(user => <Panel user={user}/>)}
            </BoardWrapper>

        );
    }
}

export default App;
