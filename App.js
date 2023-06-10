import {View, Text} from 'react-native';
import React from 'react';

const App = () => {
  return (
    <View
      style={{
        backgroundColor: 'red',
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
      }}>
      <Text style={{fontSize: 100}}>App</Text>
    </View>
  );
};

export default App;
