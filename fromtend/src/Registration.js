import React from 'react'
import { View, StyleSheet, Text, Image  , Button, TouchableOpacity} from 'react-native'
import { Actions } from 'react-native-router-flux';

export default class Registration extends React.Component {
    onSignIn(){
        Actions.signIn();
    }
    render () {
        return (
            <View style={styles.container}>
                <View style={{alignItems: "center", flex: 1}}>
                    <Image style={styles.saly}
                           source={require('../img/Saly.png')}
                    />
                    <Text style={styles.title}>Find your talent with us
                    </Text>

                    <TouchableOpacity
                        style={styles.buttonFacebookStyle}
                        activeOpacity={0.5}>
                        <Image
                            source={{
                                uri:
                                    'https://raw.githubusercontent.com/AboutReact/sampleresource/master/facebook.png',
                            }}
                            style={styles.buttonImageIconStyle}
                        />
                        <View style={styles.buttonIconSeparatorStyle} />
                        <Text style={styles.buttonTextStyle}>Facebook</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.buttonGPlusStyle} activeOpacity={0.5}>
                        <Image
                            source={{
                                uri:
                                    'https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/1004px-Google_%22G%22_Logo.svg.png',
                            }}
                            style={styles.buttonImageIconStyle}
                        />
                        <View style={styles.buttonIconSeparatorStyle} />
                        <Text style={styles.buttonTextStyleBlack}>Google</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={styles.buttonEmailStyle} activeOpacity={0.5}>
                        <Image
                            source={require('../img/email.png')}
                            style={styles.buttonImageIconStyle}
                        />
                        <View style={styles.buttonIconSeparatorStyle} />
                        <Text style={styles.buttonTextStyleBlack}>Login with Email</Text>
                    </TouchableOpacity>

                    <TouchableOpacity style={styles.buttonSign} activeOpacity={0.5} onPress={this.onSignIn.bind(this)}>

                        <Text style={styles.buttonTextStyleBlack}>Sign in</Text>
                    </TouchableOpacity>
                </View>

            </View>

        );
    }
}

const styles = StyleSheet.create ({
    container: {
        height:'100%',
        width: '100%',
        paddingTop: 10
    },
    saly: {
        height:320,
        width:320,
        alignItems: "center"
    },
    title: {
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 36,
        lineHeight: 42,

    },
    buttonGPlusStyle: {
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#ffffff',
        borderWidth: 0.5,
        height: 40,
        margin: 5,
        width: 250,
        borderColor: '#fff',
        shadowColor: '#e6e6e6',
        shadowOffset: {
            width: 0,
            height: 6,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,
        elevation: 13,
    },
    buttonFacebookStyle: {
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#485a96',
        borderWidth: 0.5,
        borderColor: '#fff',
        width: 250,
    },
    buttonEmailStyle: {
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#ffffff',
        borderWidth: 0.5,
        borderColor: '#fff',
        shadowColor: '#e6e6e6',
        shadowOffset: {
            width: 0,
            height: 6,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,
        elevation: 13,
        height: 40,
        margin: 5,
        width: 250,
    },
    buttonImageIconStyle: {
        padding: 10,
        margin: 5,
        height: 15,
        width: 12,
        resizeMode: 'stretch',
    },
    buttonTextStyle: {
        color: '#fff',
        marginBottom: 4,
        marginLeft: 10,
    },
    buttonTextStyleBlack:{
        color: '#000000',
        marginBottom: 4,
        marginLeft: 10,
    },
    buttonIconSeparatorStyle: {
        backgroundColor: '#fff',
        width: 1,
        height: 40,
    },
    buttonSign: {
        flexDirection: 'row',
        alignItems: 'center',
        backgroundColor: '#ffffff',
        borderWidth: 0.5,
        borderColor: '#fff',
        shadowColor: '#e6e6e6',
        shadowOffset: {
            width: 0,
            height: 6,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,
        elevation: 13,
        height: 40,
        margin: 5,
        width: 100,
    },
    buttonTextStyleBlackSign: {
        color: '#000000',
        marginBottom: 4,
        marginLeft: 10,
    }
})