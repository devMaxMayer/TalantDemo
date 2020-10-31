import React, {Component} from 'react';
import { Text, View, StyleSheet, TextInput, TouchableOpacity, Alert } from 'react-native';


export default class Form extends Component{
    constructor(props){
        super(props);
        this.state ={
            username: '',
            password: '',
        };
        this.textUsernameInput = null;
        this.setTextInputRef = element => {
            this.textUsernameInput = element;
        }
    }

    onValueChanged(){
        this.props.onInputChanged({ username: this.state.username, password: this.state.password});
    }

    render(){
        return(
            <View>
                <Text style={styles.inputHeader}>Username or Email</Text>
                    <TextInput                     
                      onChangeText={(username) => {
                          this.setState({username});
                          this.onValueChanged();
                        }}
                      label='Email'
                      style={styles.input}
                      onSubmitEditing={()=> this.password.focus()}
                        ref={(input) => this.username = input}
                    />
                    <Text style={styles.inputHeader}>Password</Text>
                    <TextInput
                      onChangeText={(password) => {
                          this.setState({password});
                            this.onValueChanged();
                        }}
                      label='Password'
                      secureTextEntry={true}
                      style={styles.input}
                      ref={(input) => this.password = input}                      
                    />
            </View>
        );
    }
}

const styles = StyleSheet.create({
    inputHeader: {
        paddingBottom: 5,
        fontFamily: 'Roboto',
        marginTop: 10,
        fontSize: 14,
        color: '#57586E'
    },
    input: {
        //width: 200,
        //padding: 10,
        borderBottomColor: '#57586E',
        borderBottomWidth: 1,

        marginBottom: 10,
    },
});