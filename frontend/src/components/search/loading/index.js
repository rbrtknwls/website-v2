import React from 'react';
import styles from './style.module.css';

class loading extends React.Component {

   constructor(props) {
       super(props);

       this.state = {
           spin1: "hidden",
           spin2: "hidden",
           spin3: "hidden",
           show_spin: "show",
           show_text1: "hidden",
           show_text2: "hidden",
           show_search: "hidden"
       };

       this.updateState = this.updateState.bind(this);

   }

   componentWillMount() {
        var that = this;
        setTimeout(function() {
            that.updateState(0);
   		}, 1500);
        setTimeout(function() {
            that.updateState(1);
        }, 2500);
        setTimeout(function() {
            that.updateState(2);
        }, 3500);

        setTimeout(function() {
            that.updateState(3);
        }, 5000);

        setTimeout(function() {
            that.updateState(4);
        }, 6000);

        setTimeout(function() {
            that.updateState(5);
        }, 8000);
   }

   updateState(value) {
        if (value === 0) {
            this.setState({
                spin1: "show",
            })
        }
        if (value === 1) {
            this.setState({
                spin2: "show",
            })
        }
        if (value === 2) {
            this.setState({
                spin3: "show"
            })
        }
        if (value === 3) {
            this.setState({
                show_spin: "hidden",
                show_text1: "show"
            })
        }
        if (value === 4) {
            this.setState({
                show_text2: "show"
            })
        }
        if (value === 5) {
            this.setState({
                show_search: "show"
            })
        }
   }


  render() {
    return (
        <div className = "blank">

            <div className = {this.state.show_spin}>
                <div className = "row">
                    <div className="col">
                        <div className={this.state.spin1}>
                            <div className={styles.dot}>
                                <p>.</p>
                            </div>
                        </div>
                    </div>
                    <div className="col">
                        <div className={this.state.spin2}>
                            <div className={styles.dot}>
                                <p>.</p>
                            </div>
                        </div>
                    </div>
                    <div className="col">
                          <div className={this.state.spin3}>
                              <div className={styles.dot}>
                                  <p>.</p>
                              </div>
                          </div>
                    </div>
                </div>
            </div>
            <div className = {this.state.show_text1}>
                <div className = {styles.blob}>
                    <p> Huh... its not meant look this empty I think...
                    </p>
                </div>
            </div>
            <div className = {this.state.show_text2}>
                <div className = {styles.blob}>
                    <p> I swear I coded alot more then this. Try inputting
                        what you want to know about me below, maybe that can help the algorithm out!
                    </p>
                </div>
            </div>
            <div className = {this.state.show_search}>
                <div className = {styles.search_bar}>
                    <form>
                        <input
                            type="text"
                            id="header-search"
                            placeholder="..."
                            name="s"
                        />
                        <button type="find out more">Search</button>
                    </form>
                </div>
            </div>
        </div>
    )
  }
}

export default loading;